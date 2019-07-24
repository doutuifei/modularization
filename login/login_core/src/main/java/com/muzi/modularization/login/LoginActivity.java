package com.muzi.modularization.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muzi.base.base.BaseActivity;
import com.muzi.base.constants.RouterConstant;

@Route(path = RouterConstant.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    private EditText etAccount, etPsd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
        etAccount = findViewById(R.id.et_account);
        etPsd = findViewById(R.id.et_psd);
    }

    public void btnLogin(View view) {
        String account = etAccount.getText().toString().trim();
        String psd = etPsd.getText().toString().trim();
        login(account, psd);
    }

    private void login(String account, String psd) {

    }

}
