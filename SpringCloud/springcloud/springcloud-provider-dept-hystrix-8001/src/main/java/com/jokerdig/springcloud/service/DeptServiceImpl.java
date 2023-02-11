package com.jokerdig.springcloud.service;

import com.jokerdig.springcloud.mapper.DeptMapper;
import com.jokerdig.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 11:24
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;


    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
