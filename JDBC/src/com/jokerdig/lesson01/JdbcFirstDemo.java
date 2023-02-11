package com.jokerdig.lesson01;

import java.sql.*;

/**
 * @author Joker大雄
 * @data 2022/3/21 - 11:09
 **/
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        // 连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);
        // 执行SQL的对象
        Statement statement = connection.createStatement();
        //执行SQL对象 去执行SQL 查看返回结果
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("id："+resultSet.getObject("id")+" name："+resultSet.getObject("name")+" password："+resultSet.getObject("password")+"\n");
        }
        // 释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}