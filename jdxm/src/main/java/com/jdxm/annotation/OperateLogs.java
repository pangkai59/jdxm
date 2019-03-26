package com.jdxm.annotation;

import java.lang.annotation.*;

/**
 * Created by PK on 2019/3/26.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLogs {

    String value() default "";

}
