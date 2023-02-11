package com.jokerdig.springcloud.mapper;

import com.jokerdig.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 11:14
 **/
@Mapper
@Repository
public interface DeptMapper {
    // 添加
    public boolean addDept(Dept dept);
    // 查询
    public Dept queryById(Long id);
    // 查询所有
    public List<Dept> queryAll();
}
