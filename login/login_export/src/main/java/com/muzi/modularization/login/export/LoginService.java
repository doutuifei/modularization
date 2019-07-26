package com.muzi.modularization.login.export;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.muzi.modularization.login.model.LoginRouter;

/**
 * Author: lipeng
 * Date: 2019/7/25
 * Email: lipeng@moyi365.com
 * Content:
 */
public class LoginService {

    private static final LoginService instance = new LoginService();

    private LoginService() {
    }

    public static LoginService getInstance() {
        return instance;
    }

    /**
     * 登录
     *
     * @param context
     */
    public void login(Context context) {
        ARouter.getInstance().build(LoginRouter.LOGIN_ACTIVITY).navigation(context);
    }

    /**
     * 退出登录
     *
     * @param context
     */
    public void loginout(Context context) {

    }

}
