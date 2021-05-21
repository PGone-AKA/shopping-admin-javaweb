package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAddServlet", value = "/admin/adduser")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pd = request.getParameter("password");
        String sex = request.getParameter("sex");
        String age =request.getParameter("age");
        String phone =request.getParameter("phone");
        String balance =request.getParameter("balance");
        int ag = Integer.parseInt(age);
        long pho = Long.parseLong(phone);
        double dou = Double.parseDouble(balance);
        System.out.println(email);
        System.out.println(phone);
        User user = new User(email,pd,sex,ag,pho,dou);
        AdminDao.addUser(request,user);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pd = request.getParameter("password");
        String sex = request.getParameter("sex");
        String age =request.getParameter("age");
        String phone =request.getParameter("phone");
        String balance =request.getParameter("balance");
        int ag = Integer.parseInt(age);
        long pho = Long.parseLong(phone);
        double dou = Double.parseDouble(balance);
        User user = new User(email,pd,sex,ag,pho,dou);
        AdminDao.addUser(request,user);
    }
}
