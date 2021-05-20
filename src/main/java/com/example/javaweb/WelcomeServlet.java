package com.example.javaweb;

import com.example.dao.WelcomeDao;
import com.example.test.Welcome;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", value = "/admin/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Welcome welcome = WelcomeDao.getWelcome(request);
        request.setAttribute("welcome",welcome);
        request.getRequestDispatcher("/admin/welcome.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
