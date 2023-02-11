package com.jokerdig.chat;

/**
 * @author Joker大雄
 * @data 2021/9/4 - 13:36
 **/
//客户
public class TalkClient {
    public static void main(String[] args) {
        new Thread(new TalkSeed(6666,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"用户")).start();
    }
}
