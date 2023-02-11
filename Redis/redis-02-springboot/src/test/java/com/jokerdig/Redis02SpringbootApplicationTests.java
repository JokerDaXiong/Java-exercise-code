package com.jokerdig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jokerdig.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //redisTemplate
        // opsForValue 操作字符串
        // opsForList 操作list
        // opsForSet
        // opsForHash
        // opsForZSet
        // opsForGeo
        // opsForHyperLogLog
        // 获取连接
        // RedisConnection conn = redisTemplate.getConnectionFactory().getConnection();
        // conn.flushDb();
        // conn.flushAll();
        redisTemplate.opsForValue().set("mykey","jokerdig");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    void test() throws JsonProcessingException {
        // 真实开发传递一般都使用json
        User user = new User("Joker大雄",18);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
