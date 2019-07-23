package com.muzi.modularization.login.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/22
 * Email: lipeng@moyi365.com
 * Content:
 */
@Dao
public interface LoginDao {

    @Insert
    void insert(LoginBean... loginBean);

    @Query("SELECT * FROM login_table")
    List<LoginBean> getAll();

}
