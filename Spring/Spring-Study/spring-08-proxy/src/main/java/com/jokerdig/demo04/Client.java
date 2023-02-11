package com.jokerdig.demo04;

import com.jokerdig.demo02.UserService;
import com.jokerdig.demo02.UserServiceImpl;
import org.junit.Test;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 19:19
 **/
public class Client {
    @Test
    public void test5(){
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();
        // 创建代理角色
        ProxyInvocationHandlerUtil1 handlerUtil = new ProxyInvocationHandlerUtil1();

        handlerUtil.setTarget(userService);

        // 动态生成代理类
        UserService proxy = (UserService)handlerUtil.getProxy();
        proxy.add();
        proxy.query();
    }
}
