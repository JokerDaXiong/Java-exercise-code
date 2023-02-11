package com.jokerdig.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Joker大雄
 * @data 2022/5/18 - 18:51
 **/
// 我们用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的类
    private Rent rent;
    public void setRent(Rent rent){
        this.rent = rent;
    }

    // 使用proxy创建动态代理
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       // 动态代理的本质就是使用反射机制实现
       // 增加看房
        seeHouse();
        Object result = method.invoke(rent, args);
        // 增加收取中介费
        fare();
        return result;
    }
    // 看房子
    public void seeHouse(){
        System.out.println("中介带看房子");
    }
    // 收中介费
    public void fare(){
        System.out.println("收取中介费");
    }
}
