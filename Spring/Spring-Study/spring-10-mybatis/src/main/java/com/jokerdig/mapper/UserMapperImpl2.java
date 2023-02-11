package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/5/23 - 14:23
 **/
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{

    // 继承SqlSessionDaoSupport 可以直接getSqlSession()
    public List<User> selectUser() {
        return  getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
