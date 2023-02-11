package com.jokerdig.mapper;


import com.jokerdig.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/4/23 - 15:24
 **/
public interface UserMapper {


    // 使用注解实现查询用户
    @Select("select * from user")
    List<User> getUserList();
    // 使用注解实现CRUD
    // 查询 参数需要@Param("value") 以这个为主
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id, @Param("name") String name);
    // 添加  引用对象不需要@Param 这里写实体类里的
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);
    // 修改
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
    // 删除
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
