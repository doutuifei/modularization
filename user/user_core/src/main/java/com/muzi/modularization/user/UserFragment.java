package com.muzi.modularization.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muzi.base.base.BaseFragment;
import com.muzi.base.constants.RouterConstant;
import com.muzi.module.data.DaoDatabase;
import com.muzi.modularization.login.model.LoginBean;
import com.muzi.modularization.login.model.LoginDao;
import com.muzi.modularization.user.model.UserBean;
import com.muzi.modularization.user.model.UserDao;

import java.util.List;

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

        int length = 5;
        LoginBean[] loginBeans = new LoginBean[length];
        for (int i = 0; i < length; i++) {
            loginBeans[i] = new LoginBean("account:" + i, "psd", "uid:" + i, "token");
        }

        loginDao.insert(loginBeans);

        List<LoginBean> loginBeanList = loginDao.getAll();
        for (LoginBean loginBean : loginBeanList) {
            Log.d("UserFragment", loginBean.toString());
        }

        UserBean[] userBeans = new UserBean[length];
        for (int i = 0; i < length; i++) {
//            userBeans[i] = new UserBean("name:" + i, i);
            userBeans[i] = new UserBean("name:" + i, i, i / 2 == 0 ? '男' : '女');
        }

        userDao.insert(userBeans);

        List<UserBean> userBeanList = userDao.getAll();
        for (UserBean userBean : userBeanList) {
            Log.d("UserFragment", userBean.toString());
        }

    }
}
