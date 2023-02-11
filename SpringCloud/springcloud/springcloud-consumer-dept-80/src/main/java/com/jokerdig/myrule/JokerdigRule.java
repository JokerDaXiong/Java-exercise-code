package com.jokerdig.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joker大雄
 * @data 2022/8/5 - 13:03
 **/
@Configuration
public class JokerdigRule {


    // 随机 这是官方写好的
    @Bean
    public IRule myIRule(){
        return new JokerdigRandomRule();
    }
}
