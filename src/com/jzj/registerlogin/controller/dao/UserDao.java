package com.jzj.registerlogin.controller.dao;

import com.jzj.registerlogin.controller.Exception.UserException;
import com.jzj.registerlogin.controller.model.User;
import com.jzj.registerlogin.controller.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao  {
    /**
     *
     */
    public  void  addUser(User user) throws SQLException {


            QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
            String sql="Insert into `jdbcstudy`.`user`";
            sql+="(name,accountnumber,password)";
            sql+="values(?,?,?)";
            List<Object> list=new ArrayList<Object>();
            list.add(user.getName());
            list.add(user.getAccountnumber());
            list.add(user.getPassword());
            System.out.println("123");
            System.out.println("444444444");

           int j= queryRunner.update(sql,list.toArray());
            System.out.println(j);
            System.out.println("222222222222222222222");

    }

    public  User findUser(String  accountnumber,String password)   {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        User user=null;
        String sql="select * from user where accountnumber =? and password=?";
        try {
            user=queryRunner.query(sql,new BeanHandler<User>(User.class),accountnumber,password);
            System.out.println(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;

    }
}
