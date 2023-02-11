package com.joker.test;

import redis.clients.jedis.Jedis;

/**
 * @author Joker大雄
 * @data 2022/9/17 - 10:12
 **/
public class TestPing {
    public static void main(String[] args) {
        // 1. new Jedis，使用本地redis连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // jedis有redis所有指令
        System.out.println(jedis.ping());


    }
}
