package com.muzi.modularization.login;

/**
 * Author: lipeng
 * Date: 2019/7/25
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

    private String uid;

    private String token;

    protected void setUid(String uid) {
        this.uid = uid;
    }

    protected void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }

    public void clean() {
        uid = "";
        token = "";
    }

}
