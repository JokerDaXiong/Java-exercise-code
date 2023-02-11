package com.jokerdig.test;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Joker大雄
 * @data 2022/5/5 - 12:08
 **/
public class UserTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(1);
        System.out.println(user);
        // 在查一遍同样的用户
        System.out.println("============================");
        User user1 = mapper.getUser(1);
        System.out.println(user1);
        sqlSession.close();
    }
    @Test
    public void test1(){
        // 创建两个不同的sqlsession 来测试
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user = mapper.getUser(1);
        System.out.println(user);
        // 关闭第一个sqlsession 一级缓存关闭 数据被放到二级缓存
        sqlSession.close();
        // 在查一遍同样的用户
        System.out.println("============================");
        User user1 = mapper1.getUser(1);
        System.out.println(user1);
        sqlSession1.close();

    }


}
