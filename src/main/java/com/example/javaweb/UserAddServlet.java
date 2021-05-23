package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Status;
import com.example.test.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

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
        ObjectMapper mapper = new ObjectMapper();
        Status status = new Status();
        status.setStatus(response.getStatus());
        String json = "{}";
        if (AdminDao.addUser(request,user)==1) {
            status.setMessage("添加用户成功");
            json = mapper.writeValueAsString(status);
        }else {
            status.setMessage("添加失败，该用户已经存在");
            json = mapper.writeValueAsString(status);
        }
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
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
        ObjectMapper mapper = new ObjectMapper();
        Status status = new Status();
        status.setStatus(response.getStatus());
        String json = "{}";
        if (AdminDao.addUser(request,user)==1) {
            status.setMessage("添加用户成功");
            json = mapper.writeValueAsString(status);
        }else {
            status.setMessage("添加失败，该用户已经存在");
            json = mapper.writeValueAsString(status);
        }
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
