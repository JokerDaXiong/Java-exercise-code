package com.jokerdig.controller;

import com.jokerdig.dao.DepartmentDao;
import com.jokerdig.dao.EmployeeDao;
import com.jokerdig.pojo.Department;
import com.jokerdig.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Joker大雄
 * @data 2022/7/20 - 10:18
 **/
// 员工controller
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    // 员工展示
    @RequestMapping("/emps")
    public String employeeList(Model model){
        Collection<Employee> emList = employeeDao.getAll();
        model.addAttribute("emList",emList);
        return "emp/list";
    }
    // 跳转到添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 查询所有部门信息
        Collection<Department> deList = departmentDao.getDepartments();
        model.addAttribute("deList",deList);
        return "emp/add";
    }
    // 添加员工
    @PostMapping("/emp")
    public String add(Employee employee){
        // 添加员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    // 跳转到修改页面
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model){
        // id查询员工信息
        Employee employee = employeeDao.getEmployeeById(id);
        // 查询所有部门信息
        Collection<Department> deList = departmentDao.getDepartments();
        model.addAttribute("deList",deList);
        model.addAttribute("emp",employee);
        return "emp/update";
    }
    // 修改员工
    @PostMapping("/empUpdate")
    public String update(Employee employee){
        // 修改员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    // 删除员工
    @RequestMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        // 删除
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
