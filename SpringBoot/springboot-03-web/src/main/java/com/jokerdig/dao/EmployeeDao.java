package com.jokerdig.dao;


import com.jokerdig.pojo.Department;
import com.jokerdig.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/7/18 - 10:37
 **/
// 员工dao
@Repository
public class EmployeeDao {
    // 模拟数据库数据
    private static Map<Integer, Employee> employees = null;
    // 员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"AA","aa@gmail.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","bB@gmail.com",0,new Department(102,"生活部")));
        employees.put(1003,new Employee(1003,"CC","cC@gmail.com",1,new Department(103,"体育部")));
        employees.put(1004,new Employee(1004,"DD","dD@gmail.com",0,new Department(104,"后勤部")));
        employees.put(1005,new Employee(1005,"EE","EE@gmail.com",1,new Department(105,"运营部")));
    }
    //主键自增
    private static Integer initId = 1006;
    // 添加和修改员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }
    // 查询所有员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    // 删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
