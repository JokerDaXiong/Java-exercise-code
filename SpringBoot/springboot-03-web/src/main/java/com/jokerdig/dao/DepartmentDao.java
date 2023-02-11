package com.jokerdig.dao;

import com.jokerdig.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/7/18 - 10:36
 **/
// 部门dao
@Repository
public class DepartmentDao {
    // 模拟数据库中的数据
    public static Map<Integer, Department> departments = null;
    static{
        departments = new HashMap<Integer, Department>(); // 创建部门表
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"生活部"));
        departments.put(103,new Department(103,"体育部"));
        departments.put(104,new Department(104,"后勤部"));
        departments.put(105,new Department(105,"运营部"));
    }

    // 获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    // 通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
