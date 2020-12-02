package com.jzj.registerlogin.controller.entity;

import com.mysql.cj.jdbc.result.UpdatableResultSet;

public class Reader {
   private  String  name;
   private  Integer accountnumber;
   private  String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Integer accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
