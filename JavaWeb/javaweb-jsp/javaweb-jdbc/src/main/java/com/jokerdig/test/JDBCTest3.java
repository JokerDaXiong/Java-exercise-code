package com.jokerdig.test;

import java.sql.*;

/**
 * @author Joker大雄
 * @data 2022/4/12 - 17:18
 **/
public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {
        // 配置
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 加载启动
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            // 通知数据库开启事务 关闭自动提交
           conn.setAutoCommit(false);
            // 转账
            String sql = "update account set money = money-100 where `name` ='A'";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            // 制造错误
            // int i = 1/0;
            // 转账
            String sql1 ="update account set money = money+100 where `name` ='B'";
            ps = conn.prepareStatement(sql1);
            ps.executeUpdate();
            // 提交事务
            conn.commit();
            System.out.println("转账成功");
            // 开启自动提交
            conn.setAutoCommit(true);
        } catch (Exception e) {
            try {
                // 异常就回滚事务
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 释放资源
            ps.close();
            conn.close();
        }
    }
}