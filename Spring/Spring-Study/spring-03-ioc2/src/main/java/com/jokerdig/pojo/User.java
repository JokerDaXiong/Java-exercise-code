package com.jokerdig.pojo;

/**
 * @author Joker大雄
 * @data 2022/5/11 - 11:49
 **/
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
        System.out.println("无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name:"+name);
    }
}
