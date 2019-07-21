package com.muzi.modularization.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muzi.base.constants.RouterConstant;
import com.muzi.modularization.login.model.LoginBean;

@Route(path = RouterConstant.LOGIN_ACTIVITY)
public class LoginActivity extends AppCompatActivity {

    private LoginBean loginBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
        loginBean = new LoginBean();
    }

    public void btnLogin(View view) {
        loginBean.setAccount("account");
        loginBean.setPsd("password");
        loginBean.setUid("111111");
        loginBean.setToken("sjdasf12as16451564A5AS4F6");
    }

    public void btnLogout(View view) {
        loginBean.setUid("");
        loginBean.setToken("");
    }

}
