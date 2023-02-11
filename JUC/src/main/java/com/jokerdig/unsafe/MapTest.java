package com.jokerdig.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Joker大雄
 * @data 2022/8/19 - 11:36
 **/
// 报错：java.util.ConcurrentModificationException
/*
    解决办法：
    1.Collections.synchronizedMap(new HashMap<>());
    2.new ConcurrentHashMap<>();
 */
public class MapTest {
    public static void main(String[] args) {
        // 工作中不适用HashMap
        // 默认等价于  new HashMap(16,0.75)
        // 会报错
        // Map<String,String> map = new HashMap<>();

        // 1.Collections.synchronizedMap(new HashMap<>());
        // Map<String,String> map = Collections.synchronizedMap(new HashMap<>());

        // 2.new ConcurrentHashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();
        for(int i=1;i<10;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

}
