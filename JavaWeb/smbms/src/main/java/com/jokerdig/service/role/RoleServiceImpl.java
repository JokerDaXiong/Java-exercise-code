package com.jokerdig.service.role;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.dao.role.RoleDao;
import com.jokerdig.dao.role.RoleDaoImpl;
import com.jokerdig.pojo.Role;

import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/18 - 14:15
 **/
public class RoleServiceImpl implements RoleService {

    // 引入dao
    private RoleDao roleDao;
    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    // 获取角色信息
    @Override
    public List<Role> getRoleList() {
        Connection conn = null;
        List<Role> roleList = null;
        conn = BaseDao.getConnection();

        roleList = roleDao.getRoleList(conn);

        BaseDao.closeResource(conn,null,null);

        return roleList;
    }
}
