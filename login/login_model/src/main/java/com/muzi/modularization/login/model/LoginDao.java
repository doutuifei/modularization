package com.muzi.modularization.login.model;

import org.litepal.LitePal;

import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/22
 * Email: lipeng@moyi365.com
 * Content:
 */
public class LoginDao {

    public List<LoginBean> getAll() {
        return LitePal.findAll(LoginBean.class);
    }

}
