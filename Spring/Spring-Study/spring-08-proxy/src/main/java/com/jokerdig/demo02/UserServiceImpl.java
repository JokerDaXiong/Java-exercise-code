package com.jokerdig.demo02;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 18:11
 **/
// 真实对象
public class UserServiceImpl implements UserService {
    // 现在要求我们为每一个功能增加日志 在不改变原先代码的前提

    public void add() {
        System.out.println("添加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("修改了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}
