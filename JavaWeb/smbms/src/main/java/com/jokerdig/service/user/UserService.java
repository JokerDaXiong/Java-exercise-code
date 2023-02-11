package com.jokerdig.service.user;

import com.jokerdig.pojo.Role;
import com.jokerdig.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/14 - 17:00
 **/
public interface UserService {
    //用户登录
    public User login(String userCode,String password);
    // 修改用户密码
    public boolean updatePwd(int id, String password);
    // 获取用户总数
    public int getUserCount(String username,int userRole);
    // 获取用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
    // 添加用户
    public boolean add(User user);
    // 删除用户
    public boolean deleteUserById(Integer delId);
    // 获取要求改的用户
    public User getUserById(String id);
    // 修改用户
    public boolean modify(User user);
    // 获取用户编码
    public User selectUserCodeExist(HttpServletRequest req , String userCode);
}
