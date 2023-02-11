package com.jokerdig.lesson02;

import com.jokerdig.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Joker大雄
 * @data 2022/3/21 - 13:44
 **/
public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into users(`id`,`name`,`password`,email,birthday) " +
                    "values(4,'夏明','123456','xm@qq.com','1999-01-22')";
            int back = st.executeUpdate(sql);
            if(back==1){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.release(conn,st,rs);
        }
    }
}
