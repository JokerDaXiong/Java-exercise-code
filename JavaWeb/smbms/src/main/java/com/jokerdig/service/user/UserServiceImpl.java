package com.jokerdig.service.user;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.dao.user.UserDao;
import com.jokerdig.dao.user.UserDaoImpl;
import com.jokerdig.pojo.User;
import com.jokerdig.until.Constants;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/14 - 17:00
 **/
public class UserServiceImpl implements UserService{

    // 引入Dao层
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    // 登录业务实现层
    @Override
    public User login(String userCode, String password) {
        Connection conn = null;
        User loginUser = null;

        conn= BaseDao.getConnection();
        // 通过业务层调用Dao
        loginUser = userDao.getLoginUser(conn, userCode,password);

        BaseDao.closeResource(conn,null,null);

        return loginUser;
    }
    // 修改用户面膜业务实现层
    @Override
    public boolean updatePwd(int id, String password) {
        Connection conn = null;
        boolean flag = false;
        // 获取连接
        conn = BaseDao.getConnection();
        // 通过调用Dao 修改密码
        int back = userDao.updatePwd(conn, id, password);
        if(back>0){
            flag = true;
        }
        BaseDao.closeResource(conn,null,null);
        return flag;
    }

    // 查询用户人数
    @Override
    public int getUserCount(String username, int userRole) {
        Connection conn = null;
        // 获取连接
        conn = BaseDao.getConnection();
        // 通过调用Dao 修改密码
        int count = userDao.getUserCount(conn, username, userRole);
        BaseDao.closeResource(conn,null,null);
        return count;
    }
    // 获取用户列表
    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection conn = null;
        List<User> list = null;
        // 获取连接
        conn = BaseDao.getConnection();
        // 通过调用Dao 获取用户列表
        list = userDao.getUserList(conn,queryUserName,queryUserRole,currentPageNo,pageSize);
        BaseDao.closeResource(conn,null,null);

        return list;
    }
    // 添加用户
    @Override
    public boolean add(User user) {
        boolean flag = false;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//关闭自动提交
            int back = userDao.add(conn,user);
            if(back>0){
                flag = true;
                conn.commit();
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 失败后数据回滚
            System.out.println("数据回滚");
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            // 释放资源
            BaseDao.closeResource(conn,null,null);
        }

        return flag;
    }
    // 删除用户
    @Override
    public boolean deleteUserById(Integer id) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//关闭自动提交
            if(userDao.deleteUserById(conn,id)>0){
                System.out.println("删除成功");
                flag = true;
                conn.commit();
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 失败后数据回滚
            System.out.println("数据回滚");
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            // 释放资源
            BaseDao.closeResource(conn,null,null);
        }

        return flag;
    }
    // 获取要修改的用户
    @Override
    public User getUserById(String id) {
        User user = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            user = userDao.getUserById(conn,id);
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }finally{
            BaseDao.closeResource(conn,null,null);
        }
        return user;
    }
    //修改用户
    @Override
    public boolean modify(User user) {
        boolean flag = false;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//关闭自动提交
            int back = userDao.modify(conn,user);
            if(back>0){
                flag = true;
                conn.commit();
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 失败后数据回滚
            System.out.println("数据回滚");
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            // 释放资源
            BaseDao.closeResource(conn,null,null);
        }

        return flag;
    }
    // 获取用户编码
    @Override
    public User selectUserCodeExist( HttpServletRequest req ,String userCode) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode, ((User) req.getSession().getAttribute(Constants.USER_SESSION)).getUserPassword());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }




}
