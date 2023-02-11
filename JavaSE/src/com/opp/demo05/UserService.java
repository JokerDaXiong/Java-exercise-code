package com.opp.demo05;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 14:02
 **/
public interface UserService {
    //接口中所有对象都是抽象的 修饰符默认public
    //接口中定义的是常量，一般不会这样定义
    void run();
    void delete(String name);
    void update(String age);
    void query(String name);
}
