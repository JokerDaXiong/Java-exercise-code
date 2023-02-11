package com.jokerdig.lesson04;

import com.jokerdig.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Joker大雄
 * @data 2022/3/23 - 12:29
 **/
public class TestTransaction1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            // 关闭数据库自动提交,自动开启事务
            conn.setAutoCommit(false);

            // 模拟A为B转账100
            String sql1 = "update account set money=money-100 where name='A'";
            ps=conn.prepareStatement(sql1);
            ps.executeUpdate();
            String sql2 = "update account set money=money+100 where name='B'";
            ps=conn.prepareStatement(sql2);
            ps.executeUpdate();

            // 业务完毕 提交事务
            conn.commit();
            System.out.println("提交成功");


        } catch (SQLException throwables) {
            // 提交失败 就回滚数据
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            JDBCUtils.release(conn,ps,rs);
        }


    }
}
