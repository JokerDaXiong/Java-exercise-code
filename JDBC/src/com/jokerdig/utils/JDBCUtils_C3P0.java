package com.jokerdig.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author Joker大雄
 * @data 2022/3/21 - 13:17
 **/
public class JDBCUtils_C3P0 {

    private static DataSource dataS = null;

    static{
        try {
            // 配置文件写法
            dataS=new ComboPooledDataSource("MySQL");
            // 代码也可一直接配置
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public static Connection getConnection() throws SQLException {
       return dataS.getConnection();
    }
    // 释放资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(statement!=null){
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
