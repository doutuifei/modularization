package com.muzi.annotation.utils;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
public class StringUtils {

    public static String captureName(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return new String(chars);
    }

    public static boolean isEmpty(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

}
