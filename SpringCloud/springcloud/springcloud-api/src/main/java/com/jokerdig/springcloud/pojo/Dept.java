package com.jokerdig.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 10:16
 **/
@Data
@NoArgsConstructor
@Accessors(chain=true) // 链式写法 安卓开发中有大量的链式写法
// 实体类序列化
public class Dept implements Serializable {
    private Long deptno;// 主键
    private String dname;

    // 数据存在哪个数据库的字段 微服务，一个服务对应一个数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
