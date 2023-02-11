package com.jokerdig.lesson05;

import com.jokerdig.utils.JDBCUtils_C3P0;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Joker大雄
 * @data 2022/3/23 - 13:04
 **/
public class TestC3P0 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils_C3P0.getConnection();
            String sql = "select * from users where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,5);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id："+rs.getInt("id")+" name："+rs.getString("name")+" password："+rs.getString("password")+"\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils_C3P0.release(conn,ps,rs);
        }
    }
}
