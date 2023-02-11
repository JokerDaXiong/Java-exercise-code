package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Joker大雄
 * @data 2022/7/27 - 11:26
 **/
@Repository
@Mapper
public interface UserMapper {

    // 登录
    public User queryUserByName(String name);

}
