package com.jokerdig.springcloud.service;

import com.jokerdig.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/8/8 - 12:42
 **/
// 降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {


    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>"+id+",服务端提供了降级信息，该服务暂时无法访问")
                        .setDb_source("暂时无法获取数据库信息");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
