package com.muzi.datamodule;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.muzi.base.constants.DataConstants;
import com.muzi.modularization.login.model.LoginBean;
import com.muzi.modularization.login.model.LoginDao;
import com.muzi.modularization.user.model.UserBean;
import com.muzi.modularization.user.model.UserDao;

/**
 * Author: lipeng
 * Date: 2019/7/23
 * Email: lipeng@moyi365.com
 * Content:
 */
@Database(entities = {LoginBean.class, UserBean.class},
        version = com.muzi.modularization.user.model.BuildConfig.dbVersion +
                com.muzi.modularization.login.model.BuildConfig.dbVersion)
public abstract class DaoDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract LoginDao loginDao();

    private static volatile DaoDatabase INSTANCE;

    public static DaoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DaoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DaoDatabase.class, DataConstants.DB_NAME)
                            .addMigrations(MIGRATION_3_4)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            database.execSQL("ALTER TABLE user_table ADD COLUMN 'sex' INTEGER NOT NULL DEFAULT 0");

        }
    };

}

