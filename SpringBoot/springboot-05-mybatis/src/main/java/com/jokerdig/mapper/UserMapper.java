package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/7/22 - 13:38
 **/
@Mapper
@Repository
public interface UserMapper {

    // 查询所有用户
    List<User> queryUserList();
    // id查询用户
    User queryUserById(int id);
    // 添加用户
    int addUser(User user);
    // 修改用户
    int updateUser(User user);
    // 删除用户
    int deleteUser(int id);
}
