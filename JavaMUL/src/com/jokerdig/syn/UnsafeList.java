package com.jokerdig.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2021/8/22 - 12:34
 **/
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
              synchronized (list){
                  list.add(Thread.currentThread().getName());
              }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
