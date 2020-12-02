package com.jzj.registerlogin.controller.servlet;

import com.jzj.registerlogin.controller.model.User;
import com.jzj.registerlogin.controller.service.UserService;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("11111");


        User user=new User();
        try {
            BeanUtils.populate(user,req.getParameterMap());
            UserService userService=new UserService();
            try {
                userService.register(user);
                System.out.println("are u ok?");

                req.setAttribute("success","注册成功，欢迎登录");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);

            } catch (SQLException e) {
                req.setAttribute("error","账号已存在请重新输入");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
                e.printStackTrace();
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
