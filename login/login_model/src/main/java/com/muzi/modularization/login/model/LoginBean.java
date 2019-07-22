package com.muzi.modularization.login.model;

import org.litepal.crud.LitePalSupport;

/**
 * Author: lipeng
 * Date: 2019/7/18
 * Email: lipeng@moyi365.com
 * Content:
 */
public class LoginBean extends LitePalSupport {

    private String account;

    private String psd;

    private String uid;

    private String token;

    public LoginBean() {
    }

    public LoginBean(String account, String psd, String uid, String token) {
        this.account = account;
        this.psd = psd;
        this.uid = uid;
        this.token = token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
