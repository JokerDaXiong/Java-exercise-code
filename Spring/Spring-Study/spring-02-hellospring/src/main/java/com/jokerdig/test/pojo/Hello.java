package com.jokerdig.test.pojo;

/**
 * @author Joker大雄
 * @data 2022/5/11 - 10:49
 **/
public class Hello {
    private String name;

    public Hello(String name) {
        this.name = name;
    }

    public Hello() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
