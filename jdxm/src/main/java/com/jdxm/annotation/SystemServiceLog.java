package com.jdxm.annotation;

import java.lang.annotation.*;

/**
 * ClassName: SystemServiceLog <br/>
 * Function: AOP日志记录，自定义注解 <br/>
 * @author zhangwr
 * @date 2018/4/27.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    /**
     * 日志描述
     */
    String description()  default "";

    /**
     * 操作表类型
     */
    int tableType() default 0;
}