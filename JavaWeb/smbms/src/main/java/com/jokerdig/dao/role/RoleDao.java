package com.jokerdig.dao.role;

import com.jokerdig.pojo.Role;

import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/18 - 14:07
 **/
public interface RoleDao {
    // 获取角色列表
    public List<Role> getRoleList(Connection conn);

}
