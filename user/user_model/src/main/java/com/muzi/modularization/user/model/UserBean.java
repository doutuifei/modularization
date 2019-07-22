package com.muzi.modularization.user.model;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
public class UserBean {

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

}
