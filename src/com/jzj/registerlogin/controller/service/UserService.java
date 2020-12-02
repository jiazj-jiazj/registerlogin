package com.jzj.registerlogin.controller.service;

import com.jzj.registerlogin.controller.Exception.UserException;
import com.jzj.registerlogin.controller.dao.UserDao;
import com.jzj.registerlogin.controller.model.User;

import java.sql.SQLException;

public class UserService {
    /**
     *   register service
     */
    UserDao userDao=new UserDao();

    public  void register(User user) throws SQLException {

            userDao.addUser(user);


    }

    public  User login (String accountnumber,String password) throws UserException
    {
        User user=userDao.findUser(accountnumber,password);

        if(user==null)
        {
            throw  new UserException("用户名不存在或者密码错误");
        }

        return  user;
    }
}
