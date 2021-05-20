package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberEditServlet", value = "/admin/member-id")
public class MemberIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("id");
        String name = request.getParameter("name");
        int id = Integer.parseInt(ids);
        ServletContext application = request.getServletContext();
        application.setAttribute("member-id",id);
        request.setAttribute("member-name",name);
        request.getRequestDispatcher("/admin/member-edit.jsp").forward(request,response);

        /*String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String balance = request.getParameter("balance");
        System.out.println(sex);
        System.out.println(age);
        System.out.println(phone);
        System.out.println(balance);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
