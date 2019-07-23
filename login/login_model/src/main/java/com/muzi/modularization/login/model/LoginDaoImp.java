package com.muzi.modularization.login.model;

import org.litepal.LitePal;

import java.util.Arrays;
import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/23
 * Email: lipeng@moyi365.com
 * Content:
 */
public class LoginDaoImp implements LoginDao {
    @Override
    public void insert(LoginBean... loginBean) {
        List<LoginBean> loginBeans = Arrays.asList(loginBean);
        LitePal.saveAll(loginBeans);
    }

    @Override
    public List<LoginBean> getAll() {
        return LitePal.findAll(LoginBean.class);
    }

}
