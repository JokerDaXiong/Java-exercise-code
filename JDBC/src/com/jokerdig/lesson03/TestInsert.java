package com.jokerdig.lesson03;

import com.jokerdig.utils.JDBCUtils;

import java.sql.*;
import java.util.Date;

/**
 * @author Joker大雄
 * @data 2022/3/21 - 13:44
 **/
public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            // 用占位符 ? 进行占位，之后在赋值 防止sql注入
            String sql = "insert into users(`id`,`name`,`password`,email,birthday) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql); // 预编译sql，先写SQL 不执行
            // 手动给参数赋值
            ps.setInt(1,5);
            ps.setString(2,"小白");
            ps.setString(3,"123123");
            ps.setString(4,"xb@qq.com");
            /*
                注意点:
                sql.Date    SQL   java.sql.Date();
                util.Date  Java   new Date().getTime(); 获得时间戳
             */
            ps.setDate(5,new java.sql.Date(new Date().getTime()));
            // 执行
            int back = ps.executeUpdate();
            if(back==1){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.release(conn,ps,null);
        }
    }
}
