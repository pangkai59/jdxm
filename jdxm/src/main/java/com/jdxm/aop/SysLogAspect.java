package com.jdxm.aop;

import com.alibaba.fastjson.JSON;
import com.jdxm.annotation.OperateLogs;
import com.jdxm.entity.basic.SysLog;
import com.jdxm.entity.basic.User;
import com.jdxm.service.base.SysLogService;
import com.jdxm.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.shiro.SecurityUtils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by PK on 2019/3/26.
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;


    @Pointcut( "@annotation(com.jdxm.annotation.OperateLogs)")
    public void logPoinCut( )   {
    }

    @Before(value=" logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws Exception {
        System.out.println("开启切面");
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        OperateLogs myLog = method.getAnnotation(OperateLogs.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setUrl(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        sysLog.setParams(params);

        sysLog.setCreateTime(new Date());
        //获取用户名
        User user=(User)SecurityUtils.getSubject().getPrincipal();
     //   sysLog.setUserId(user.getUid());
        //获取用户ip地址
        sysLog.setIp(IpUtils.getIpAdress());

        //调用service保存SysLog实体类到数据库
        sysLogService.insert(sysLog);
    }

}
