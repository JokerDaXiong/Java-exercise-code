package com.jokerdig.mapper;


import com.jokerdig.pojo.User;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/23 - 15:24
 **/
public interface UserMapper {
    // 根据id查询用户
    User getUserById(int id);

}
