package com.tarena.web;

import java.io.Serializable;

/**
 * 值对象：用来传递值的对象！
 * Created by SkyOne on 2016/10/7.
 */
public class FormBean implements Serializable{
    private String name;
    private String pwd;

    public FormBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
