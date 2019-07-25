package com.muzi.modularization.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muzi.base.base.BaseActivity;
import com.muzi.base.constants.RouterConstant;

@Route(path = RouterConstant.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    private EditText etAccount, etPsd;
    private ProgressBar progressBar;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
        etAccount = findViewById(R.id.et_account);
        etPsd = findViewById(R.id.et_psd);
        progressBar = findViewById(R.id.progressbar);
    }

    public void btnLogin(View view) {
        String account = etAccount.getText().toString().trim();
        String psd = etPsd.getText().toString().trim();
        login(account, psd);
    }

    private void login(String account, String psd) {
        if (progressBar.getVisibility() == View.VISIBLE) {
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);

    }

}
