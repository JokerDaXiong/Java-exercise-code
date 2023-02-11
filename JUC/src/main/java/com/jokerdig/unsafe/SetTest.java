package com.jokerdig.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Joker大雄
 * @data 2022/8/19 - 10:29
 **/
// 报错：java.util.ConcurrentModificationException
/*
    解决办法：
    1. Collections.synchronizedSet(new HashSet<>());
    2. new CopyOnWriteArraySet<>();
 */
public class SetTest {
    public static void main(String[] args) {
        // 报错
        // Set<String> set = new HashSet<>();

        // 1.Collections.synchronizedSet(new HashSet<>());
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());

        // 2.new CopyOnWriteArraySet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for(int i=1;i<10;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }
}
