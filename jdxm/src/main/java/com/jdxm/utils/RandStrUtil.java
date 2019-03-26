package com.jdxm.utils;

import java.util.Random;

/**
 * Created by swk on 2017/10/7.
 * jd.wang@renrunkeji.com
 */
public class RandStrUtil {

    private static String SOURCE_NUMERIC = "0123456789";
    private static String SOURCE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String SOURCE_MIXED = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generate(int len, String source) {
        Random random = new Random(System.currentTimeMillis());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int idx = random.nextInt(source.length() - 1);
            sb.append(source.charAt(idx));
        }

        return sb.toString();
    }

    public static String genNumeric(int len) {
        return generate(len, SOURCE_NUMERIC);
    }

    public static String genAlphabet(int len) {
        return generate(len, SOURCE_ALPHABET);
    }

    public static String genMixed(int len) {
        return generate(len, SOURCE_MIXED);
    }
}
