package com.example.listener;

import com.example.tools.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("jdbc代理池创建！！");
        //Jdbc连接池
        JdbcUtil jUtil= new JdbcUtil();
        Map<Connection,Boolean> map = new HashMap();
        for (int i = 0; i < 5; i++) {
            Connection conn = jUtil.getConn();

            map.put(conn,true);
        }
        ServletContext context = sce.getServletContext();
        context.setAttribute("JdbcPool",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("jdbc代理池销毁！！");
       ServletContext context= sce.getServletContext();
       Map map = (Map) context.getAttribute("JdbcPool");
       Iterator itr = map.keySet().iterator();
        while (itr.hasNext()) {
            Connection conn =(Connection)itr.next();
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
