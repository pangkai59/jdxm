package com.jdxm.common.exception;

import org.apache.shiro.authc.DisabledAccountException;

/**
 * @Author: yp.huang@renrunkeji.com
 * @Description:
 * @Date: Created on 2018/06/01
 * @Modified By:
 */
public class ExpireAccountException extends DisabledAccountException {


    public ExpireAccountException() {
        super();
    }

    public ExpireAccountException(String message) {
        super(message);
    }
}
