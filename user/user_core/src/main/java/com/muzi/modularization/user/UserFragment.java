package com.muzi.modularization.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muzi.base.base.BaseFragment;
import com.muzi.base.constants.RouterConstant;
import com.muzi.modularization.login.export.LoginService;
import com.muzi.modularization.login.model.LoginDao;
import com.muzi.modularization.user.model.UserDao;
import com.muzi.module.data.DaoDatabase;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author: lipeng
 * Date: 2019/7/19
 * Email: lipeng@moyi365.com
 * Content:
 */
@Route(path = RouterConstant.USER_FRAGMENT)
public class UserFragment extends BaseFragment {

    public static SupportFragment getInstance() {
        SupportFragment fragment = new UserFragment();
        fragment.setArguments(null);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DaoDatabase database = DaoDatabase.getDatabase(getContext());
        LoginDao loginDao = database.loginDao();
        UserDao userDao = database.userDao();

        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginService.getInstance().login(getContext());
            }
        });
        view.findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginService.getInstance().loginout(getContext());
            }
        });
    }
}
