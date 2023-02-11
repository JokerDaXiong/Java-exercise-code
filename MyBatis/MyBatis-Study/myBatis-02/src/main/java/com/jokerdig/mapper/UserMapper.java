package com.jokerdig.mapper;

import com.jokerdig.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/4/23 - 15:24
 **/
public interface UserMapper {
    // 查询所有
    List<User> getUserList();
    // 根据id查询用户
    User getUserById(int id);
    // 添加
    int add(User user);
    // 修改
    int update(User user);
    // 删除
    int delete(int id);

}
