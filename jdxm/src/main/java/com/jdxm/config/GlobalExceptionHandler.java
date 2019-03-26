package com.jdxm.config;

import com.jdxm.common.constant.RTConstant;
import com.jdxm.common.constant.StatusConstant;
import com.jdxm.common.exception.CodeRuntimeException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * Created by admin on 2019/3/22.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = UnauthenticatedException.class)
    @ResponseBody
    public RTConstant unauthenticatedExceptionHandler(UnauthenticatedException e) {

        return new RTConstant(StatusConstant.ERR, "未登录");

    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public RTConstant unauthorizedExceptionHandler(Exception e) throws Exception {
        logger.error(e.getMessage(), e);

        return new RTConstant(StatusConstant.ERR, "您没有权限");
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = CodeRuntimeException.class)
    @ResponseBody
    public RTConstant codeRuntimeExceptionHandler(CodeRuntimeException e) {
        logger.error(e.getMessage(), e);

        return new RTConstant(e.getCode(), e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public RTConstant runtimeExceptionHandler(RuntimeException e) {
        logger.error(e.getMessage(), e);
        e.printStackTrace();
        return new RTConstant(StatusConstant.ERR, e.getMessage());
    }

    // 实体类方法入参统一校验
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public RTConstant methodArgumentNotValidExceptionHandler(Exception e) throws Exception {
        String message = e.getMessage();
        logger.error(message.substring(message.lastIndexOf("[") + 1, message.lastIndexOf("]") - 1));
        return new RTConstant(StatusConstant.ERR, e.getMessage());
    }

    // RequestParam入参统一校验
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = ValidationException.class)
    @ResponseBody
    public RTConstant validationExceptionHandler(Exception e) throws Exception {
        return new RTConstant(StatusConstant.ERR, e.getMessage());
    }

    // 数据库 键冲突
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public RTConstant duplicateKeyExceptionHandler(Exception e) throws Exception {
        String message = e.getMessage();
        logger.error(message.substring(message.lastIndexOf("entry") + 5, message.lastIndexOf("for")) + "重复，请仔细检查！！！");
        return new RTConstant(StatusConstant.ERR, e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RTConstant exceptionHandler(Exception e) throws Exception {
        logger.error(e.getMessage(), e);
        e.printStackTrace();
        return new RTConstant(StatusConstant.ERR, e.getMessage());

    }

}
