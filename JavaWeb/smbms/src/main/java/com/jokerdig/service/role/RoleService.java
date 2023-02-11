package com.jokerdig.service.role;

import com.jokerdig.pojo.Role;

import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/18 - 14:15
 **/
public interface RoleService {
    // 获取角色列表
    public List<Role> getRoleList();

}
