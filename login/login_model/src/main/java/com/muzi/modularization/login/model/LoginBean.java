package com.muzi.modularization.login.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author: lipeng
 * Date: 2019/7/18
 * Email: lipeng@moyi365.com
 * Content:
 */
@Entity
public class LoginBean {

    private String account;

    private String psd;

    private String uid;

    private String token;

    public LoginBean() {
    }

    @Generated(hash = 1457856878)
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
