package com.muzi.modularization.login.model;

import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/22
 * Email: lipeng@moyi365.com
 * Content:
 */
public interface LoginDao {

    void insert(LoginBean... loginBean);

    List<LoginBean> getAll();

}
