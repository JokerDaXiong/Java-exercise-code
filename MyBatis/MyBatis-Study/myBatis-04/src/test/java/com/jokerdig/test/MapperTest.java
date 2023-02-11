package com.jokerdig.test;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/4/27 - 14:44
 **/
public class MapperTest {
    // 查询所有
    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            // 获得sqlSession对象
            sqlSession = MyBatisUtil.getSqlSession();
            // 执行sql
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // mapper调用查询方法
            User user = mapper.getUserById(1);
            // 输出查询结果
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
    // 分页
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Integer> userMap = new HashMap<String, Integer>();

        userMap.put("startIndex",0);
        userMap.put("pageSize",2);

        List<User> userByList = mapper.getUserByList(userMap);

        for (User user : userByList) {
            System.out.println(user);
        }

        sqlSession.close();

    }
    // RowBounds分页
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // RowBounds实现分页
        RowBounds rowBounds = new RowBounds(0,2);
        List<User> userList = sqlSession.selectList("com.jokerdig.mapper.UserMapper.getUserRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
