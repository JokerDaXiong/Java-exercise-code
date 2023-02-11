package com.jokerdig.dao.user;

import com.jokerdig.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/14 - 16:37
 **/
public interface UserDao {
    // 得到要登录的用户
    public User getLoginUser(Connection conn,String userCode,String userPassword);
    // 修改用户密码
    public int updatePwd(Connection conn,int id, String password);
    // 获取用户总数
    public int getUserCount(Connection conn,String username,int userRole);
    // 获取用户列表
    public List<User> getUserList(Connection conn,String userName,int userRole,int currentPageNo,int pageSize);
    // 添加用户
    public int add(Connection conn,User user);
    // 删除用户
    public int deleteUserById(Connection conn,Integer delId);
    // 获取修改用户
    public User getUserById(Connection conn,String id);
    // 修改用户
    public int modify(Connection conn,User user);
}
