package com.muzi.modularization.user.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
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
public interface UserDao {

    @Insert
    void insert(UserBean... userBean);

    @Query("SELECT * FROM user_table")
    List<UserBean> getAll();

    @Delete
    void delete(UserBean userBean);
}
