package com.jokerdig.service;

import com.jokerdig.pojo.User;

/**
 * @author Joker大雄
 * @data 2022/7/27 - 11:31
 **/
public interface UserService {
    // 登录
    public User queryUserByName(String name);
}
