package com.jokerdig.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Joker大雄
 * @data 2022/5/14 - 14:10
 **/
@Component
public class User {
    @Value("李四")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
