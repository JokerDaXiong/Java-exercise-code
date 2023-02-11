package com.joker.test;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author Joker大雄
 * @data 2022/9/17 - 10:23
 **/
public class TXDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();// 清空数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "jokerdig");
        String str = jsonObject.toJSONString();
        // 测试事务
        // 开启事务
        Transaction multi = jedis.multi();

        try {
            multi.set("user1", str);
            multi.set("user2", str);
            int i = 1 / 0; // 异常代码
            multi.exec(); // 执行事务
        } catch (Exception e) {
            multi.discard();// 放弃事务，抛出异常
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            // 关闭连接
            jedis.close();
        }
    }
}
