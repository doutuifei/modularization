package com.muzi.modularization.user.model;

import org.litepal.LitePal;

import java.util.Arrays;
import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/23
 * Email: lipeng@moyi365.com
 * Content:
 */
public class UserDaoImp implements UserDao {

    @Override
    public void insert(UserBean... userBean) {
        List<UserBean> userBeans = Arrays.asList(userBean);
        LitePal.saveAll(userBeans);
    }

    @Override
    public List<UserBean> getAll() {
        return LitePal.findAll(UserBean.class);
    }

}
