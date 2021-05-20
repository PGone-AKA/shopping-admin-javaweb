package com.example.tools;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/supermarket?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PD = "yang611612";
    private Connection conn;
    private PreparedStatement ps;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(HttpServletRequest request){
        Map map = (Map) request.getServletContext().getAttribute("JdbcPool");
        Iterator itr = map.keySet().iterator();
        while (itr.hasNext()){
            Connection conn = (Connection) itr.next();
            if ((boolean) map.get(conn)==true){
                this.conn = conn;
                map.put(conn,false);
            }
        }
        return this.conn;
    }

    public Connection getConn() {
        try{
            this.conn = DriverManager.getConnection(URL,USER,PD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.conn;
    }

    public PreparedStatement getPs(HttpServletRequest request,String sql) {
        try {
            this.ps = getConn(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.ps;
    }

    public PreparedStatement getPs(String sql) {
        try {
            this.ps = getConn().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.ps;
    }
    public void close(){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }
    public void close(HttpServletRequest request){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        Map map = (Map) request.getServletContext().getAttribute("JdbcPool");
        map.put(conn,true);
    }
    public void close(HttpServletRequest request,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(request);
    }

}
