package com.jokerdig.test;

import java.sql.*;

/**
 * @author Joker大雄
 * @data 2022/4/12 - 17:08
 **/
public class JDBCTest2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 配置
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
        String username="root";
        String password="123456";
        // 加载启动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,username,password);
        // 编写sql
        String sql="select * from users where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);
        ResultSet re = ps.executeQuery();
        while(re.next()){
            System.out.println("id:"+re.getObject("id"));
            System.out.println("name:"+re.getObject("name"));
            System.out.println("password:"+re.getObject("pwd"));
            System.out.println("email:"+re.getObject("email"));
            System.out.println("birthday:"+re.getObject("birthday"));
        }
        // 释放资源
        re.close();
        ps.close();
        conn.close();
    }
}
