package com.muzi.modularization.user.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
public class UserBean extends LitePalSupport {

    @Column(unique = true)

    private int id;

    private String name;

    private int age;

    public UserBean() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
