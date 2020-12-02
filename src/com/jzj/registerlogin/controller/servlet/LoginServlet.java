package com.jzj.registerlogin.controller.servlet;

import com.jzj.registerlogin.controller.Exception.UserException;
import com.jzj.registerlogin.controller.model.User;
import com.jzj.registerlogin.controller.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountnumber=req.getParameter("accountnumber");

        String password=req.getParameter("password");

        UserService userService=new UserService();

        try {
            User user=userService.login(accountnumber,password);
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/loginsuccess.jsp").forward(req,resp);
        } catch (UserException e) {
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
