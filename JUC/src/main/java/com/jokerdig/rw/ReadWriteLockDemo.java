package com.jokerdig.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Joker大雄
 * @data 2022/8/22 - 16:23
 **/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        // MyCache cache = new MyCache();
        MyCacheLock cacheLock = new MyCacheLock();
        // 写入
        for (int i = 0; i <=5 ; i++) {
            final int temp = i;
            new Thread(()->{
                cacheLock .put(temp+"",temp+"");
            },String.valueOf(i)).start();

        }
        // 读取
        for (int i = 0; i <=5 ; i++) {
            final int temp = i;
            new Thread(()->{
                cacheLock .get(temp+"");
            },String.valueOf(i)).start();

        }

    }
}

/*
    自定义缓存
 */
// 加锁的
class MyCacheLock{
    // 模拟的缓存
    private volatile Map<String,Object> map = new HashMap<>();
    // 读写锁 更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /*
        加锁后，我们希望
        写的时候只有一个线程来写
        读的时候所有人都可以读
     */
    // 存 写入
    public void put(String key,Object value){
        // 写锁->独占锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入中...");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            readWriteLock.writeLock().unlock();
        }
    }
    // 取 读取
    public void get(String key){
       // 读锁->共享锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取中...");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            readWriteLock.readLock().unlock();
        }
    }

}

// 未加锁 出现插队问题
/*
class MyCache{
    // 模拟的缓存
    private volatile Map<String,Object> map = new HashMap<>();

    // 存 写入
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入中...");
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完毕！");
    }
    // 取 读取
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取中...");
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完毕！");
    }

}
*/