package com.jokerdig.test;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/27 - 14:44
 **/
public class MapperTest {
    // 查询所有
    @Test
    public void test(){
        // 获得sqlSession对象
        SqlSession  sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper调用查询方法
        List<User> userList = mapper.getUserList();
        // 输出查询结果
        for (User user : userList) {
            System.out.println(user);
        }
        // 关闭sqlSession
        sqlSession.close();
    }
    // id查询
    @Test
    public void getUserById(){
        // 获得sqlSession对象
        SqlSession  sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper调用查询方法
        User user = mapper.getUserById(1,"admin");
        // 输出查询结果
            System.out.println(user);
        // 关闭sqlSession
        sqlSession.close();
    }
    // 添加
    @Test
    public void addUser(){
        // 获得sqlSession对象
        SqlSession  sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper调用添加方法
        mapper.addUser(new User(5, "小呆呆", "123123"));
        // 关闭sqlSession
        sqlSession.close();
    }
    // 修改
    @Test
    public void updateUser(){
        // 获得sqlSession对象
        SqlSession  sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper调用修改方法
        mapper.updateUser(new User(5, "小呆瓜", "33333"));
        // 关闭sqlSession
        sqlSession.close();
    }
    // 删除
    @Test
    public void deleteUser(){
        // 获得sqlSession对象
        SqlSession  sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper调用删除方法
        mapper.deleteUser(6);
        // 关闭sqlSession
        sqlSession.close();
    }
}
