package com.jokerdig.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Joker大雄
 * @data 2022/4/13 - 21:01
 **/
// 陈宗座数据库公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块 类加载就初始化
    static {
        Properties pro = new Properties();
        // 通过类加载器读取行响应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = pro.getProperty("driver");
        url = pro.getProperty("url");
        username = pro.getProperty("username");
        password = pro.getProperty("password");
    }
    // 获取数据库连接
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    // 编写查询公共类
    public static ResultSet execute(Connection conn,PreparedStatement ps,ResultSet re,String sql,Object[] para) throws SQLException {
        ps = conn.prepareStatement(sql);

        for (int i = 0; i < para.length; i++) {
            // setObject 占位符从1开始
            ps.setObject(i+1,para[i]);
        }
        re = ps.executeQuery();
        return re;
    }
    // 编写增删改公共方法
    public static int execute(Connection conn,PreparedStatement ps,String sql,Object[] para) throws SQLException {
        ps = conn.prepareStatement(sql);

        for (int i = 0; i < para.length; i++) {
            // setObject 占位符从1开始
            ps.setObject(i+1,para[i]);
        }
        int back = ps.executeUpdate();
        return back;
    }
    // 释放资源
    public static boolean closeResource(Connection conn,PreparedStatement ps,ResultSet re){
        boolean flag = true;
        if(re!=null){
            try {
                re.close();
                re=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        if(ps!=null){
            try {
                ps.close();
                ps=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        if(conn!=null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }
}
