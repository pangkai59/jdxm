package com.jdxm.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName AES加解密工具类
 * @author Yinxz E-mail:(yinxz@primeton.com)
 * @date 创建时间：2017年11月16日 上午10:23:04
 **/
public class AesEncryptUtil {

    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    public static String base64Encode(byte[] bytes){  
        return Base64.encodeBase64String(bytes);  
    }  
    
    public static byte[] base64Decode(String base64Code) throws Exception{  
    	return  Base64.decodeBase64(base64Code);
    }  
    
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128);  
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);  
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));  

        return cipher.doFinal(content.getBytes("utf-8"));  
    }  
    
    /**
     * AES加密
     * @param content
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {  
        return base64Encode(aesEncryptToBytes(content, encryptKey));  
    } 
    
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128);  

        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);  
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));  
        byte[] decryptBytes = cipher.doFinal(encryptBytes);  

        return new String(decryptBytes);  
    }  
    
    /**
     * AES解密
     * @param encryptStr
     * @param decryptKey
     * @return
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {  
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);  
    }  
    
    
    public static void main(String[] args) {
    	String content = "{\"result\":\"true \",\"oaUsers\": [{\"userName\": \"CMCC_USER1\",\"phoneNum\": \"13888888888\",\"e-mail\": \"13888888888@139.com\",\"orgId\": \"2\"},{\"userName\": \"CMCC_USER2\",\"phoneNum\": \"13899999999\",\"e-mail\": \"13899999999@139.com\",\"orgId\": \"3\"}],\"errDesc\":\"\"}";
    	String encryptKey = "cmccsjjsdampapis";
		try {
			String encryptStr = aesEncrypt(content, encryptKey);
			System.out.println("加密字符串："+encryptStr);
			
			String decryptStr = aesDecrypt(encryptStr, encryptKey);
			System.out.println("解密字符串："+decryptStr);
			
			System.out.println(decryptStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
