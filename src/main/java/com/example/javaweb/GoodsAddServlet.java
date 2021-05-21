package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GoodsAddServlet", value = "/admin/addgoods")
public class GoodsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gname = request.getParameter("gname");
        double bid = Double.parseDouble(request.getParameter("bid"));
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Goods goods = new Goods(gname,bid,price,stock);
        AdminDao.addGood(request,goods);
    }
}
