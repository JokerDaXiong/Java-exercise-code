package com.jokerdig.demo;

/**
 * @author Joker大雄
 * @data 2021/9/7 - 17:07
 **/
//什么叫反射
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.jokerdig.demo.User");
        System.out.println(c1);
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        Class c2 = Class.forName("com.jokerdig.demo.User");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());



    }
}

//实体类 pojo,entity
class User{
    private String name;
    private int age;
    private int id;

    public User() {
    }

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}