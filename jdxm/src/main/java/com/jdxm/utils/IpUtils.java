package com.jdxm.utils;

import java.net.InetAddress;

/**
 * IP工具类
 * User: PK
 * Date: 2019/3/26
 * Time: 11:01
 */
public class IpUtils {


    public static String getIpAdress() {
        InetAddress ia = null;
        String localip="";
        try {
            ia = ia.getLocalHost();
            String localname = ia.getHostName();
             localip = ia.getHostAddress();
            System.out.println("本机名称是：" + localname);
            System.out.println("本机的ip是 ：" + localip);
        } catch (Exception e) {
            e.printStackTrace();
        }
          return localip;
    }
}