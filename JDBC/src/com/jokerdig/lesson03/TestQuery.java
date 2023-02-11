package com.jokerdig.lesson03;

import com.jokerdig.utils.JDBCUtils;

import java.sql.*;

/**
 * @author Joker大雄
 * @data 2022/3/21 - 13:29
 **/
public class TestQuery {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.release(conn,ps,rs);
        }
    }
}
