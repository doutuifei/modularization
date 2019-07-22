package com.muzi.modularization.login.model;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.muzi.annotation.annotation.RegisterApplication;
import com.muzi.annotationapi.AbsApplication;
import com.muzi.base.constants.DataConstants;
import com.muzi.modularization.login.greendao.DaoMaster;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
@RegisterApplication(priority = 1000)
public class SqlDao extends AbsApplication {

    private static SqlDao instance;

    private SQLiteDatabase sqLiteDatabase;

    public SqlDao() {
    }

    public static SqlDao getInstance() {
        return instance;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        instance = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, DataConstants.DB_NAME);
        sqLiteDatabase = helper.getWritableDatabase();
    }

}
