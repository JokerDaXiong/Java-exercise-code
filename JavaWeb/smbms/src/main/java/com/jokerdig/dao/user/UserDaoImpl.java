package com.jokerdig.dao.user;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.pojo.User;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/14 - 16:39
 **/
public class UserDaoImpl implements UserDao{

    // 用户登录
    @Override
    public User getLoginUser(Connection conn, String userCode,String userPassword) {
        PreparedStatement ps =null;
        ResultSet re = null;
        User user = null;
        if(conn!=null){
            String sql ="select * from smbms_user where userCode=? and userPassword=?";
            Object [] para = {userCode,userPassword};

            try {
                re=BaseDao.execute(conn,ps,re,sql,para);
                if(re.next()){
                    user = new User();
                    user.setId(re.getInt("id"));
                    user.setUserCode(re.getString("userCode"));
                    user.setUserName(re.getString("userName"));
                    user.setUserPassword(re.getString("userPassword"));
                    user.setGender(re.getInt("gender"));
                    user.setBirthday(re.getDate("birthday"));
                    user.setPhone(re.getString("phone"));
                    user.setAddress(re.getString("address"));
                    user.setUserRole(re.getInt("userRole"));
                    user.setCreatedBy(re.getInt("createdBy"));
                    user.setCreationDate(re.getTimestamp("creationDate"));
                    user.setModifyBy(re.getInt("modifyBy"));
                    user.setModifyDate(re.getTimestamp("modifyDate"));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally{
                //释放资源
                BaseDao.closeResource(null,ps,re);
            }
        }
        return user;
    }
    // 修改密码
    @Override
    public int updatePwd(Connection conn, int id, String password) {
        PreparedStatement ps =null;
        int back=0;

        if(conn!=null){
            String sql ="update smbms_user set userPassword=? where id=?";
            Object [] para = {password,id};
            try {
                back=BaseDao.execute(conn,ps,sql,para);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally{
                //释放资源
                BaseDao.closeResource(null,ps,null);
            }
        }
        return back;
    }

    // 查询用户总人数
    @Override
    public int getUserCount(Connection conn, String username, int userRole) {
        PreparedStatement ps =null;
        ResultSet re = null;
        int count = 0;

        if(conn!=null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user su, smbms_role sr where su.userRole = sr.id");
            ArrayList<Object> list = new ArrayList<>();

            if (!StringUtils.isNullOrEmpty(username)) {
                // username不为空
                sql.append(" and su.userName like ?");
                list.add("%" + username + "%");
            }
            if (userRole > 0) {
                // userRole不为空
                sql.append(" and su.userRole = ?");
                list.add(userRole);
            }
            // 把list转换为数组
            Object[] arr = list.toArray();
            // 调试sql语句是否正常
            System.out.println("UserDaoImpl->getUserCount:" + sql.toString());

            try {
                re = BaseDao.execute(conn, ps, re, sql.toString(), arr);
                if (re.next()) {
                    // 取出总人数
                    count = re.getInt("count");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, re);
            }
        }
            return count;
    }

    // 查询用户列表
    @Override
    public List<User> getUserList(Connection conn, String userName, int userRole, int currentPageNo, int pageSize) {
        PreparedStatement ps =null;
        ResultSet re = null;
        List<User> userList = new ArrayList<>();
        if(conn!=null){
           StringBuffer sql = new StringBuffer();
           sql.append("select su.*,sr.roleName as userRoleName from smbms_user su,smbms_role sr where su.userRole = sr.id");
           List<Object> list = new ArrayList<>();
            if (!StringUtils.isNullOrEmpty(userName)) {
                // username不为空
                sql.append(" and su.userName like ?");
                list.add("%" + userName + "%");
            }
            if (userRole > 0) {
                // userRole不为空
                sql.append(" and su.userRole = ?");
                list.add(userRole);
            }
            /*
                    在数据库中 分页使用  limit  startIndex,pageSize 总数
                    当前页  (当前页-1)*页面大小
                    0,5    0 1 2 3 4
                    5,5    5 6 7 8 9
                    ....
             */
            sql.append(" order by creationDate DESC limit ?,?");
            // 分页计算
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] para = list.toArray();
            System.out.println("getUserListSQL->"+sql.toString());
            try {
                re=BaseDao.execute(conn,ps,re,sql.toString(),para);
                while(re.next()){
                    User user = new User();
                    user.setId(re.getInt("id"));
                    user.setUserCode(re.getString("userCode"));
                    user.setUserName(re.getString("userName"));
                    user.setGender(re.getInt("gender"));
                    user.setBirthday(re.getDate("birthday"));
                    user.setUserRole(re.getInt("userRole"));
                    user.setUserRoleName(re.getString("userRoleName"));
                    userList.add(user);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally{
                //释放资源
                BaseDao.closeResource(null,ps,re);
            }
        }
        return userList;
    }

    // 添加用户
    @Override
    public int add(Connection conn, User user) {
        PreparedStatement ps = null;
        int back = 0;
        if(conn!=null){
            String sql = "insert into smbms_user (userCode,userName,userPassword,"+
                    "userRole,gender,birthday,phone,address,creationDate,createdBy)"+
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] para = {user.getUserCode(), user.getUserName(), user.getUserPassword(),
                    user.getUserRole(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getCreationDate(), user.getCreatedBy()};
            try {
                back = BaseDao.execute(conn,ps,sql,para);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                BaseDao.closeResource(null,ps,null);
            }
        }
        return back;
    }

    // 删除用户
    @Override
    public int deleteUserById(Connection conn, Integer delId) {
        PreparedStatement ps = null;
        int back = 0;
        if(conn!=null){
            String sql = "delete from smbms_user where id=?";
            Object[] para = {delId};
            try {
                back = BaseDao.execute(conn,ps,sql,para);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                BaseDao.closeResource(null,ps,null);
            }
        }
        return back;
    }
    // 获取修改用户
    @Override
    public User getUserById(Connection conn, String id) {
        PreparedStatement ps =null;
        ResultSet re = null;
        User user = null;

        if(conn!=null) {
            conn = BaseDao.getConnection();
            String sql = "select su.*,sr.roleName as userRoleName from smbms_user su,smbms_role sr where su.id=? and su.userRole = sr.id";
            Object[] para = {id};
            try {
                re=BaseDao.execute(conn,ps,re,sql,para);
                while(re.next()){
                    user = new User();
                    user.setId(re.getInt("id"));
                    user.setUserCode(re.getString("userCode"));
                    user.setUserName(re.getString("userName"));
                    user.setUserPassword(re.getString("userPassword"));
                    user.setGender(re.getInt("gender"));
                    user.setBirthday(re.getDate("birthday"));
                    user.setPhone(re.getString("phone"));
                    user.setAddress(re.getString("address"));
                    user.setUserRole(re.getInt("userRole"));
                    user.setCreatedBy(re.getInt("createdBy"));
                    user.setCreationDate(re.getTimestamp("creationDate"));
                    user.setModifyBy(re.getInt("modifyBy"));
                    user.setModifyDate(re.getTimestamp("modifyDate"));
                    user.setUserRoleName(re.getString("userRoleName"));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally{
                //释放资源
                BaseDao.closeResource(null,ps,re);
            }
        }
        return user;
    }
    // 修改用户
    @Override
    public int modify(Connection conn, User user) {
        int back = 0;
        PreparedStatement pstm = null;
        if (null != conn) {
            String sql = "update smbms_user set userName=?," +
                    "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {user.getUserName(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getUserRole(), user.getModifyBy(),
                    user.getModifyDate(), user.getId()};
            try {
                back = BaseDao.execute(conn, pstm, sql, params);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            BaseDao.closeResource(null, pstm, null);
        }
        return back;
    }




}
