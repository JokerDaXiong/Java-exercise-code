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
}
