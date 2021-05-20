package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String url = "/myweb/admin/login.html";*/
        //重定向
        response.sendRedirect("/myweb/admin/index.html");
        //转发
        /*request.getRequestDispatcher("/admin/index.html" ).forward(request,response);*/
        /*response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("<p><a href=\"admin/find_user\">1.查看会员数量</a></p>");
        out.print("<p><a href=\"admin/find_user\">1.查看商品清单</a></p>");
        out.print("<p><a href=\"admin/find_user\">1.查看今日流水</a></p>");*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
