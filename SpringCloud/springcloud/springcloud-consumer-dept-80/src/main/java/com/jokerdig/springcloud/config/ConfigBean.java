package com.jokerdig.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Joker大雄
 * @data 2022/8/3 - 15:14
 **/
@Configuration
public class ConfigBean {

    // 配置负载均衡实现RestTemplate
    // IRule
    // RoundRobinRule 轮询
    // RandomRule 随机
    // AvailabilityFilterIngRule：过滤掉故障服务
    // RetryRule 先按照轮询获取服务，如果获取失败，在指定时间内重试
    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
