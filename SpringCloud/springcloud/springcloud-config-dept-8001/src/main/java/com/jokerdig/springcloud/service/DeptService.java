package com.jokerdig.springcloud.service;

import com.jokerdig.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 11:23
 **/
public interface DeptService {
    // 添加
    public boolean addDept(Dept dept);
    // 查询
    public Dept queryById(Long id);
    // 查询所有
    public List<Dept> queryAll();
}

