package com.jokerdig.demo02;

import org.junit.Test;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 18:16
 **/
public class UserTest {
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        // 使用代理方法
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        // 测试调用
        proxy.add();
        proxy.update();
        proxy.delete();
        proxy.query();



    }

}
