package com.jokerdig.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.rmi.UnknownHostException;

/**
 * @author Joker大雄
 * @data 2022/9/17 - 11:49
 **/
@Configuration
public class RedisConfig {
    // 自定义redistemplate
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory)
        throws UnknownHostException{
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 配置具体序列化
        Jackson2JsonRedisSerializer jrs = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator());
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        jrs.setObjectMapper(objectMapper);
        StringRedisSerializer serializer = new StringRedisSerializer();
        // key采用String序列化方式
        template.setKeySerializer(serializer);
        // hash的key也采用String序列化
        template.setHashKeySerializer(serializer);
        // value序列化采用jackson
        template.setValueSerializer(jrs);
        template.afterPropertiesSet();
        return template;
    }
}
