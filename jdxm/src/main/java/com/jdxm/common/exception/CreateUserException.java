package com.jdxm.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Author: yp.huang@renrunkeji.com
 * @Description:
 * @Date: Created on 2018/05/11
 * @Modified By:
 */
public class CreateUserException extends AuthenticationException {

    public CreateUserException(String message) {
        super(message);
    }
}
