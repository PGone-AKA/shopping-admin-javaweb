package com.example.test;

import com.example.dao.AdminDao;
import com.example.dao.WelcomeDao;
import com.example.tools.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd%");
        String time = df.format(new Date());
        JdbcUtil jdbc = new JdbcUtil();
        String sql = "select sum(goods.price*record.num) from record,goods where record.datetime like ? and record.gid = goods.id ";
        PreparedStatement ps = jdbc.getPs(sql);
        ResultSet rs = null;
        try {
            ps.setObject(1,time);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getDouble(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close(rs);
        }


    }
}
