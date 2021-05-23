package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Goods;
import com.example.test.Status;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

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
        ObjectMapper mapper = new ObjectMapper();
        Status status = new Status();
        status.setStatus(response.getStatus());
        String json = "{}";
        if (AdminDao.addGood(request,goods)==1) {
            status.setMessage("添加商品成功");
            json = mapper.writeValueAsString(status);
        }else {
            status.setMessage("添加失败，该商品已经存在");
            json = mapper.writeValueAsString(status);
        }
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);


    }
}
