package com.muzi.modularization.login.model.interfaces;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Author: lipeng
 * Date: 2019/7/25
 * Email: lipeng@moyi365.com
 * Content:
 */
public interface LoginApi extends IProvider {

    void login();

    void loginSuccess(String uid, String token, Object o);

    void loginFailed();

}
