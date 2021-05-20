package com.example.javaweb;

import com.example.dao.AdminDao;
import com.example.test.Record;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "RecordServlet", value = "/admin/record")
public class RecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Record> list = AdminDao.record(request);
        Iterator<Record> ito = list.iterator();
        request.setAttribute("record",ito);
        request.getRequestDispatcher("/admin/order-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
