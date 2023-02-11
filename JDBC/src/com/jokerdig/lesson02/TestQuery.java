package com.jokerdig.lesson02;

import com.jokerdig.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Joker大雄
 * @data 2022/3/21 - 13:29
 **/
public class TestQuery {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            String sql = "select * from users";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println("id："+rs.getInt("id")+" name："+rs.getString("name")+" password："+rs.getString("password")+"\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.release(conn,st,rs);
        }
    }
}
