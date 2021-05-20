package com.example.javaweb;

import com.example.dao.AdminDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemEditServlet", value = "/admin/edit")
public class MemEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =(Integer) request.getServletContext().getAttribute("member-id");
        String sex = request.getParameter("sex");
        String age =request.getParameter("age");
        String phone =request.getParameter("phone");
        String balance =request.getParameter("balance");
        int ag = Integer.parseInt(age);
        long pho = Long.parseLong(phone);
        double dou = Double.parseDouble(balance);
        AdminDao.editUser(request,id,sex,ag,pho,dou);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
