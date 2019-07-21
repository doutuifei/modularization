package com.muzi.modularization.login.model;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.muzi.annotation.annotation.RegisterApplication;
import com.muzi.annotationapi.AbsApplication;
import com.muzi.base.constants.DataConstants;
import com.muzi.modularization.login.greendao.DaoMaster;
import com.muzi.modularization.login.greendao.DaoSession;

/**
 * Author: lipeng
 * Date: 2019/7/18
 * Email: lipeng@moyi365.com
 * Content:
 */
@RegisterApplication
public class LoginDao extends AbsApplication {

    private static LoginDao instance;

    private DaoSession daoSession;

    private LoginDao() {
    }

    public static LoginDao getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        instance = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, DataConstants.DB_NAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

}
