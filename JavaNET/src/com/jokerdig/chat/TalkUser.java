package com.jokerdig.chat;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 13:35
 **/
//用户
public class TalkUser {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSeed(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"客户")).start();
    }
}
