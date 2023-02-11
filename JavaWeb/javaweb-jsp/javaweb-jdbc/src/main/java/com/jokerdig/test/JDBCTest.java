package com.jokerdig.test;

import java.sql.*;

/**
 * @author Joker大雄
 * @data 2022/4/12 - 13:36
 **/
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 配置
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
        String username="root";
        String password="123456";
        // 加载启动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,username,password);

        Statement st = conn.createStatement();
        // 编写sql
        String sql="select * from users";
        ResultSet re = st.executeQuery(sql);
        while(re.next()){
            System.out.println("id:"+re.getObject("id"));
            System.out.println("name:"+re.getObject("name"));
            System.out.println("password:"+re.getObject("pwd"));
            System.out.println("email:"+re.getObject("email"));
            System.out.println("birthday:"+re.getObject("birthday"));
        }
        // 释放资源
        re.close();
        st.close();
        conn.close();
    }
}
