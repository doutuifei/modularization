package com.muzi.modularization.login.model;

/**
 * Author: lipeng
 * Date: 2019/7/19
 * Email: lipeng@moyi365.com
 * Content:
 */
public class LoginData {

    private static final LoginData ourInstance = new LoginData();

    public static LoginData getInstance() {
        return ourInstance;
    }

    private LoginData() {
    }

    private static String uid;

    private static String token;

    public static String getUid() {
        return uid;
    }

    public static String getToken() {
        return token;
    }

}
