package com.jokerdig.single;

import java.lang.reflect.Constructor;

/**
 * @author Joker大雄
 * @data 2022/8/27 - 11:11
 **/
/*
    根据下方的问题可以发现，即使如何去防止，总有破坏单例的问题,该如何解决？
 */
public class Reflex {

    // 使用红绿灯解决都是反射创建的破坏
    private static boolean flag = false;

    // 构造器私有
    private Reflex(){
        synchronized (Reflex.class){
            // 通过红绿灯阻止破坏单例，但是如果flag也被拿到并修改呢？
            if(flag == false){
                flag=true;
            }else{
                throw new RuntimeException("不要试图破坏单例");
            }
//            if(reflex!=null){
//                // 说明来破坏单例，若不为null 直接抛出下方异常
//                // 但是还会有问题，如果两个都是通过反射创建呢？
//                throw new RuntimeException("不要试图破坏单例");
//            }
        }
        System.out.println(Thread.currentThread().getName()+"ok");

    }
    // 添加volatile
    private volatile static Reflex reflex;
    // 双重检测锁模式的懒汉式单例 DCL懒汉式
    public static Reflex getInstance(){
        if(reflex ==null){
            // 加锁
            synchronized (Lazy.class){
                if(reflex==null){
                    reflex = new Reflex(); //不是原子性操作
                }
            }
        }
        return reflex;
    }

    public static void main(String[] args) throws Exception{
        // 反射破坏单例模式
       // Reflex instance = Reflex.getInstance();
        Constructor<Reflex> constructor = Reflex.class.getDeclaredConstructor(null);
        // 使用反射破坏单例
        constructor.setAccessible(true); // 无视私有构造器
        Reflex instance1 = constructor.newInstance();
        // 都通过反射创建，单例又被破坏，抛出异常无效
        Reflex instance = constructor.newInstance();
        // 打印instance 发现两个instance地址不同，单例被破坏
        System.out.println(instance);
        System.out.println(instance1);
    }
}
