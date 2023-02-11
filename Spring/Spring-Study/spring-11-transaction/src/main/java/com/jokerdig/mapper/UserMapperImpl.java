package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/5/23 - 14:06
 **/
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{

    // 查询所有
    public List<User> selectUser() {
        User user = new User(4, "小王", "123123");
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.add(user);
        mapper.delete(5);
        return mapper.selectUser();
    }

    //添加
    public int add(User user) {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.add(user);
    }

//    删除
    public int delete(int id) {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.delete(id);
    }

}
