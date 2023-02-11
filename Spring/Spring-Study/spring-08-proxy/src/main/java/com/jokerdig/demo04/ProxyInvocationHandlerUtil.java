package com.jokerdig.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 19:13
 **/
// 编写代理工具类
public class ProxyInvocationHandlerUtil implements InvocationHandler {

    // 被代理的类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 使用proxy创建动态代理
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质就是使用反射机制实现
        Object result = method.invoke(target, args);
        return result;
    }
}
