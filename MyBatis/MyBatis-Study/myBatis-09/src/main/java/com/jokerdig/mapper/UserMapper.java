package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/5/5 - 12:12
 **/
public interface UserMapper {
    // 查询用户
    User getUser(@Param("id") int id);

}
