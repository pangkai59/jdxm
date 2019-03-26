package com.jdxm.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLock {

    /**
     * 锁多少时间
     */
    int time() default 5;

    /**
     * 锁类型
     */
    String type() default "";

}
