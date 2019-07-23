package com.muzi.modularization.login.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Author: lipeng
 * Date: 2019/7/18
 * Email: lipeng@moyi365.com
 * Content:
 */
@Entity(tableName = "login_table")
public class LoginBean {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String account;

    private String psd;

    private String uid;

    private String token;

    public LoginBean() {
    }

    @Ignore
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", psd='" + psd + '\'' +
                ", uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
