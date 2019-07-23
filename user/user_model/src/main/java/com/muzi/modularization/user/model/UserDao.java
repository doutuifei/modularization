package com.muzi.modularization.user.model;

import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/22
 * Email: lipeng@moyi365.com
 * Content:
 */
public interface UserDao {

    void insert(UserBean... userBean);

    List<UserBean> getAll();

}
