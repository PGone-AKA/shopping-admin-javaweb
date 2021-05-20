package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if (session!=null){
            if (session.getAttribute("adminSession")!=null){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        if(request.getRequestURI().indexOf("login")!=-1){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        servletRequest.getRequestDispatcher("/admin/login.html").forward(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
