package com.jokerdig.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 * @author Joker大雄
 * @data 2022/4/23 - 15:22
 **/
// @Data可以帮我们实现get、set、toString、hashCode、无参构造
// @AllArgsConstructor 有参构造
@Data
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;

}
