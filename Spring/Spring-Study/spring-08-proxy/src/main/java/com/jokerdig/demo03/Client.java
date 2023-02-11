package com.jokerdig.demo03;

import org.junit.Test;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 18:59
 **/
public class Client {
    @Test
    public void test3(){
        // 真实角色
        Host host = new Host();
        // 代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        // 通过调用程序处理角色来处理我们要调用的接口对象
        handler.setRent(host);
        // 这里的proxy就是动态生成的，我们并没有写
        Rent proxy = (Rent) handler.getProxy();
        proxy.rent();
    }
}