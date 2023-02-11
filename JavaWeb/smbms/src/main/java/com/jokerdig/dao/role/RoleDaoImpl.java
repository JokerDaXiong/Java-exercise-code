package com.jokerdig.dao.role;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/18 - 14:10
 **/
public class RoleDaoImpl implements RoleDao{

    // 获取角色列表
    @Override
    public List<Role> getRoleList(Connection conn) {
        PreparedStatement ps =null;
        ResultSet re = null;
        List<Role> list = new ArrayList<>();
        if(conn!=null){
            String sql = "select * from smbms_role";
            Object[] para = {};
            try {
                re = BaseDao.execute(conn, ps, re, sql, para);
                while(re.next()){
                    Role role = new Role();
                    role.setId(re.getInt("id"));
                    role.setRoleName(re.getString("roleName"));
                    role.setRoleCode(re.getString("roleCode"));
                    list.add(role);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally{
                //释放资源
                BaseDao.closeResource(null,ps,re);
            }
        }
        return list;
    }

}
