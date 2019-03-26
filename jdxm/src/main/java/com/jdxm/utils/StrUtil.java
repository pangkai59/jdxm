package com.jdxm.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swk on 2017/10/9.
 * jd.wang@renrunkeji.com
 */
public class StrUtil {

    // 手机号的正则
    private static Pattern mobilePattern = Pattern.compile("\\d{11}");

    public static List<Integer> splitToInt(String s, String sep) {
        if (s == null || s.equals("")) {
            return null;
        }

        String[] sArr = s.split(sep);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < sArr.length; i++) {
            arr.add(Integer.parseInt(sArr[i]));
        }

        return arr;
    }

    public static List<String> splitToStr(String s, String sep) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] sArr = s.split(sep);
        return Arrays.asList(sArr);
    }

    /**
     * 把List拼接成字符串
     *
     * @param vars
     * @param sep
     * @return
     */
    public static String joinInt(List<Integer> vars, String sep) {
        StringBuilder sb = new StringBuilder();
        for (Integer var : vars) {
            if (sb.length() == 0) {
                sb.append(var);
            } else {
                sb.append(sep);
                sb.append(var);
            }
        }

        return sb.toString();
    }

    /**
     * 把List拼接成字符串
     *
     * @param vars
     * @param sep
     * @return
     */
    public static String joinStr(List<String> vars, String sep) {
        StringBuilder sb = new StringBuilder();
        for (String var : vars) {
            if (sb.length() == 0) {
                sb.append(var);
            } else {
                sb.append(sep);
                sb.append(var);
            }
        }

        return sb.toString();
    }

    /**
     * 安全的substring
     * safeSubstring0("abcde", 3) => abc
     * safeSubstring0("abcde", 10) => abcde
     *
     * @param origin
     * @param len
     * @return
     */
    public static String safeSubstring0(String origin, int len) {
        if (origin == null) {
            return "";
        }

        if (origin.length() > len) {
            return origin.substring(0, len);
        }

        return origin;
    }

    /**
     * 过滤掉混在utf8里的非utf8字符
     * "於正\uD87E\uDC25" => "於正"
     *
     * @param str
     * @return
     */
    public static String filterUtf8mb4(String str) {
        final int LAST_BMP = 0xFFFF;
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            if (codePoint < LAST_BMP) {
                sb.appendCodePoint(codePoint);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static String star(String str, int start, int len) {
        if (str == null) {
            return "";
        }

        if (str.length() < start) {
            return str;
        }

        int left = str.length() - start;

        len = len > left ? left : len;

        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, start));

        for (int i = 0; i < len; i++) {
            sb.append("*");
        }

        if (str.length() < (start + len)) {
            return sb.toString();
        }

        sb.append(str.substring(start + len));
        return sb.toString();
    }


    /**
     * 检查字符串是否是合法的字符串
     *
     * @param str 需要校验的字符串
     * @return boolean
     */
    public static boolean isMobile(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        Matcher m = mobilePattern.matcher(str);

        return m.matches();
    }


}
