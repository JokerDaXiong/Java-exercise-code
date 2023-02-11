package com.jokerdig.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Joker大雄
 * @data 2021/8/22 - 13:28
 **/
//测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> clist = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                clist.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(clist.size());
    }
}
