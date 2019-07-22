package com.muzi.modularization.user;

import android.app.Application;

import com.muzi.annotation.annotation.RegisterApplication;
import com.muzi.annotationapi.AbsApplication;
import com.muzi.modularization.login.model.SqlDao;
import com.muzi.modularization.user.greendao.DaoMaster;
import com.muzi.modularization.user.greendao.DaoSession;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
@RegisterApplication(priority = 10)
public class UserDao extends AbsApplication {

    private static UserDao instance;

    private DaoSession daoSession;

    private UserDao() {
    }

    public static UserDao getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        instance = this;
        DaoMaster daoMaster = new DaoMaster(SqlDao.getInstance().getSqLiteDatabase());
        daoSession = daoMaster.newSession();
    }

}
