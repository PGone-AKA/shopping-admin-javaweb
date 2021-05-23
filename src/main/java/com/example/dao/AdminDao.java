package com.example.dao;

import com.example.test.Admin;
import com.example.test.Goods;
import com.example.test.Record;
import com.example.test.User;
import com.example.tools.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AdminDao {
    private static final JdbcUtil util = new JdbcUtil();

    /**
     * @param admin 管理员登录验证
     * @return ture登录成功
     */
    public static Boolean login(HttpServletRequest request,Admin admin){
        String sql = "select count(*) num from admin where name=? and password = ?";
        PreparedStatement ps= util.getPs(request,sql);

        ResultSet rs = null;
        try {
            ps.setObject(1,admin.getName());
            ps.setObject(2,admin.getPassword());
            rs = ps.executeQuery();
            while (rs.next()){
                //用户存在只有一个
                if(rs.getInt("num")==1) return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                util.close(request,rs);
            }
        }
        return false;
    }

    //查询所有用户
    public static List<User> findAll(HttpServletRequest request){
        List userList= new LinkedList<User>();
        String sql = "select uid,uname,upd,usex,uage,uphone,ubalance,udate from user ";
        PreparedStatement ps= util.getPs(request,sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getLong(6),
                        rs.getDouble(7),rs.getString(8));
                userList.add(user);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                util.close(request,rs);
            }
        }
        return userList;
    }

    public static List<User> findAll(){
        List userList= new LinkedList<User>();
        String sql = "select uid,uname,upd,usex,uage,uphone,ubalance from user ";
        PreparedStatement ps= util.getPs(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getLong(6),rs.getDouble(7));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                util.close(rs);
            }

        }
        return userList;
    }

    //增加用户
    public static int addUser(HttpServletRequest request,User user){
        int flag = 0;
        String sql = "insert into user(uname,upd,usex,uage,uphone,ubalance,udate) " +
                "values(?,?,?,?,?,?,?)";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PreparedStatement ps = util.getPs(request,sql);
        try {
            ps.setObject(1,user.getName());
            ps.setObject(2,user.getPd());
            ps.setObject(3,user.getSex());
            ps.setObject(4,user.getAge());
            ps.setObject(5,user.getPhone());
            ps.setObject(6,user.getBalance());
            ps.setObject(7,df.format(new Date()));
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return flag;
    }

    //删除用户
    public static int delUser(HttpServletRequest request,int id){
        int flag = 0;
        String sql = "delete from user where uid = ?";
        PreparedStatement ps = util.getPs(request,sql);
        try {
            ps.setObject(1,id);
            flag =  ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return  flag;
    }
    //修改用户信息
    public static int editUser(HttpServletRequest request ,int id,String sex,int age,Long phone,double balance){
        int flag = 0;
        String sql = "update user set usex = ?,uage = ? ,uphone = ? , ubalance = ? where uid = ?";
        PreparedStatement ps = util.getPs(request,sql);
        try {
            ps.setObject(1,sex);
            ps.setObject(2,age);
            ps.setObject(3,phone);
            ps.setObject(4,balance);
            ps.setObject(5,id);
            flag = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return flag;
    }
    //流水记录
    public static List<Record> record(HttpServletRequest request){
        String sql = "select rid ,user.uname,gname,num,price,datetime from record ,goods,user where record.gid = goods.id and record.uid = user.uid";
        PreparedStatement ps = util.getPs(request,sql);
        ResultSet rs = null;
        List<Record> records = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                records.add(new Record(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getDouble(5),df.format(rs.getDate(6))));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                util.close(request,rs);
            }
        }
        return records;

    }

    //查看商品

    public static  List<Goods> goodList(HttpServletRequest request){
        String sql = "select id,gname,bid,price,stock from goods";
        List<Goods> list = new ArrayList<>();
        PreparedStatement ps = util.getPs(request,sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Goods(rs.getInt(1),rs.getString(2),rs.getDouble(3)
                ,rs.getDouble(4),rs.getInt(5)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs!=null){
                util.close(request,rs);
            }
        }
        return  list;
    }

    //添加商品
    public static int addGood(HttpServletRequest request,Goods good){
        int flag = 0;
        String sql = "insert into goods(gname,bid,price,stock) values(?,?,?,?)";
        PreparedStatement ps = util.getPs(request,sql);
        try {
            ps.setObject(1,good.getGname());
            ps.setObject(2,good.getBid());
            ps.setObject(3,good.getPrice());
            ps.setObject(4,good.getStock());
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(request);
        }
        return flag;
    }
}
