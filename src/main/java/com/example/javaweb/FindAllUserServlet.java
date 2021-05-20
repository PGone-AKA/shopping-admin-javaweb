package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Admin;
import com.example.test.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<User> userList = AdminDao.findAll(request);
        Iterator<User> ito = userList.iterator();
        request.setAttribute("userFind",ito);
        request.getRequestDispatcher("/admin/member-list.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
