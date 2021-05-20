package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Admin;
import com.example.test.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session==null){
            request.getRequestDispatcher("/admin/login.html").forward(request,response);
        }else {
            Object admin = session.getAttribute("adminSession");
            if (admin==null){
                request.getRequestDispatcher("/admin/login.html").forward(request,response);
            }else {
                response.sendRedirect("/myweb/admin");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin  = new Admin();
        String name = request.getParameter("UserName");
        String pd = request.getParameter("password");
        System.out.println("name:"+name);
        System.out.println("pd:"+pd);
        admin.setName(name);
        admin.setPassword(pd);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (AdminDao.login(request,admin)) {
            //全局作用域对象   存放servlet共享数据
            ServletContext sc = request.getServletContext();
            sc.setAttribute("adminCookie",admin);

            //cookie存储在客户端的浏览器的缓存中，浏览器关闭cookie被销毁
            Cookie cookie = new Cookie("admin",admin.getName());
            response.addCookie(cookie);

            //session（用户的储物柜）存储在服务端，一般为30分钟
            HttpSession session = request.getSession();
            session.setAttribute("adminSession",admin);
            response.sendRedirect("/myweb/admin");
        }else {
            String result = "<h1>登录失败！！！</h1>";
            out.print(result);
        }


    }
}
