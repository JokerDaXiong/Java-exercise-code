package com.jokerdig.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Joker大雄
 * @data 2022/8/18 - 11:09
 **/
// 多线程下List安全问题
// java.util.ConcurrentModificationException 并发修改异常

public class ListTest {
    public static void main(String[] args) {

        /*
            解决方案 ：
            1. 使用Vector<> 默认是安全的(不推荐) Vector底层是添加了synchronized
            2. 使用Collections.synchronizedList(new ArrayList<>());
            3. 使用new CopyOnWriteArrayList<>(); 推荐
         */
        /*
            CopyOnWrite 写入时复制  COW 计算机程序设计领域的一种优化策略
            多个线程调用的时候，list，读取的时候，固定的，写入(覆盖)
            再写入的时候避免覆盖，造成数据问题
            读写分离  主要优化CopyOnWrite读取的时候不加锁而synchronized在读取的时候也是加锁的
        */

        // 并发下 ArrayList是不安全的
        // List<String> list = new ArrayList<>();
        // 1. 使用Vector<> 默认是安全的
        // List<String> list = new Vector<>();
        // 2. 使用 Collections.synchronizedList(new ArrayList<>())
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        // 3. 使用new CopyOnWriteArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i =0;i<10;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
