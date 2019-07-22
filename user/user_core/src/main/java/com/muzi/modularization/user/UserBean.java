package com.muzi.modularization.user;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
@Entity
public class UserBean {

    private String name;

    private int age;

    public UserBean() {
    }

    @Keep
    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
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

}
