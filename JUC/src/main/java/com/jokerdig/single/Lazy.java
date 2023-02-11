package com.jokerdig.single;

/**
 * @author Joker大雄
 * @data 2022/8/27 - 10:34
 **/
// 懒汉式单例
public class Lazy {
    // 构造器私有
    private Lazy(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    // 添加volatile
    private volatile static Lazy lazy;

    public static  Lazy getInstance(){
        // 双重检测锁模式的懒汉式单例 DCL懒汉式
        if(lazy==null){
            // 加锁
            synchronized (Lazy.class){
                if(lazy==null){
                    lazy = new Lazy(); //不是原子性操作，可能发生指令重排问题
                    /*
                        1. 分配内存空间
                        2. 执行构造方法，初始化对象
                        3. 把这个对象指向内存空间
                        假设由多条线程存在
                        A 132
                        B  // 此时lazy还没有完成构造
                        必须加volatile
                     */
                }
            }
        }
        return lazy;
    }
    // 单线程下没问题，多线程下,创建会出问题
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lazy.getInstance();
            }).start();
        }
    }




}
