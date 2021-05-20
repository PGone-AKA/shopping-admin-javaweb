package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "java<br/>c++<br/>python<br/>";
        String url = "http://www.baidu.com";
        response.sendRedirect(url);
        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(result);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        System.out.println("url:"+url);
        System.out.println("uri:"+uri);
        System.out.println("method:"+method);*/
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String value = request.getParameter(paramName);
            System.out.println(paramName + ":" + value);
        }
    }
}
