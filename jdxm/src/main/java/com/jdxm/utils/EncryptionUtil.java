package com.jdxm.utils;


import org.apache.shiro.crypto.hash.SimpleHash;

public class EncryptionUtil {

    /**
     * 最最普通的MD5加密
     */
    public static String simpleMD5(String s){
        return new SimpleHash("MD5", s).toBase64();
    }

}
