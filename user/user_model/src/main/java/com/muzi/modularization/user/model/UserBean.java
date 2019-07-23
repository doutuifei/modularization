package com.muzi.modularization.user.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
@Entity(tableName = "user_table")
public class UserBean {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private int age;

    private char sex='男';

    public UserBean() {
    }

    @Ignore
    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Ignore
    public UserBean(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

}
