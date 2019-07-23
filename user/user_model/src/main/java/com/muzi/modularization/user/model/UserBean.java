package com.muzi.modularization.user.model;

import org.litepal.crud.LitePalSupport;

/**
 * Author: lipeng
 * Date: 2019/7/21
 * Email: lipeng@moyi365.com
 * Content:
 */
public class UserBean extends LitePalSupport {

    private String name;

    private int age;

    private char sex='男';

    public UserBean() {
    }

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

}
