package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/5/23 - 13:25
 **/
public interface UserMapper {
    public List<User> selectUser();
    // 添加一个用户
    public int add(User user);
    // 删除一个用户
    public int delete(int id);
}
