package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "GoodListServlet", value = "/admin/goodlist")
public class GoodListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = AdminDao.goodList(request);
        Iterator<Goods> itr = list.iterator();
        request.setAttribute("goodslist",itr);
        request.getRequestDispatcher("/admin/goods-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
