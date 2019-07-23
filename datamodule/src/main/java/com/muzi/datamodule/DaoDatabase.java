package com.muzi.datamodule;

import android.content.Context;

import com.muzi.modularization.login.model.LoginDao;
import com.muzi.modularization.login.model.LoginDaoImp;
import com.muzi.modularization.user.model.UserDao;
import com.muzi.modularization.user.model.UserDaoImp;

/**
 * Author: lipeng
 * Date: 2019/7/23
 * Email: lipeng@moyi365.com
 * Content:
 */
public class DaoDatabase {

    private UserDao userDaoImp;

    public UserDao userDao() {
        if (userDaoImp == null) {
            userDaoImp = new UserDaoImp();
        }
        return userDaoImp;
    }

    private LoginDao loginDaoImp;

    public LoginDao loginDao() {
        if (loginDaoImp == null) {
            loginDaoImp = new LoginDaoImp();
        }
        return loginDaoImp;
    }

    private static volatile DaoDatabase INSTANCE;

    private DaoDatabase() {
    }

    public static DaoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DaoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DaoDatabase();
                }
            }
        }
        return INSTANCE;
    }

}

