package com.jokerdig.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Joker大雄
 * @data 2022/5/14 - 13:30
 **/
// 组件
@Component
// 作用域
@Scope("singleton")
public class User {
    // 相当于bean中的property
    @Value("张三")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
