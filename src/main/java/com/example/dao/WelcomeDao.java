package com.example.dao;


import com.example.test.Admin;
import com.example.test.Welcome;
import com.example.tools.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WelcomeDao {
    private static final JdbcUtil JDBC_UTIL= new JdbcUtil();
    private void Welcome(){

    }

    public static Welcome getWelcome(HttpServletRequest request){
        HttpSession session = request.getSession();
        Welcome welcome = new Welcome();
        //管理员昵称
        Admin admin = (Admin) session.getAttribute("adminSession");
        welcome.setAdmin(admin.getName());
        //用户数量
        String sql = "select count(*) from user";
        PreparedStatement ps = JDBC_UTIL.getPs(request,sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setUser_number(rs.getInt(1));
            }
            //商品数量
            sql = "select count(*) from goods";
            ps = JDBC_UTIL.getPs(request,sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setGoods_number(rs.getInt(1));
            }
            //总营业额
            sql = "select sum(goods.price*record.num) from record,goods where record.gid = goods.id";
            ps = JDBC_UTIL.getPs(request,sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setTotal_account(rs.getDouble(1));
            }
            //今日营业额
            sql = "select sum(goods.price*record.num) from record,goods where record.datetime like ? and record.gid = goods.id ";
            ps = JDBC_UTIL.getPs(request,sql);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd%");
            ps.setObject(1,df.format(new Date()));
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setDay_account(rs.getDouble(1));
            }
            //总利润
            sql = "select sum(goods.bid*record.num) from record,goods where record.gid = goods.id";
            ps = JDBC_UTIL.getPs(request,sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setTotal_profit(welcome.getTotal_account()-rs.getDouble(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC_UTIL.close(request,rs);
        }
        return welcome;
    }

    public static Welcome getWelcome(){

        Welcome welcome = new Welcome();
        //管理员昵称

        welcome.setAdmin("admin");
        //用户数量
        String sql = "select count(*) from user";
        PreparedStatement ps = JDBC_UTIL.getPs(sql);
        ResultSet rs = null;
        try {

            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setUser_number(rs.getInt(1));
            }
            //商品数量
            sql = "select count(*) from goods";
            ps = JDBC_UTIL.getPs(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setGoods_number(rs.getInt(1));
            }
            //总营业额
            sql = "select sum(goods.price*record.num) from record,goods where record.gid = goods.id";
            ps = JDBC_UTIL.getPs(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setTotal_account(rs.getDouble(1));
            }
            //今日营业额
            sql = "select sum(goods.price*record.num) from record,goods where record.datetime like ? and record.gid = goods.id ";
            ps = JDBC_UTIL.getPs(sql);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd%");
            ps.setObject(1,new Date());
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setDay_account(rs.getDouble(1));
            }
            //总利润
            sql = "select sum(goods.bid*record.num) from record,goods where record.gid = goods.id";
            ps = JDBC_UTIL.getPs(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                welcome.setTotal_profit(welcome.getTotal_account()-rs.getDouble(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC_UTIL.close(rs);
        }
        return welcome;
    }
}
