package com.jokerdig.service;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joker大雄
 * @data 2022/7/27 - 11:32
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapper;

    @Override
    public User queryUserByName(String name) {
        return mapper.queryUserByName(name);
    }
}
