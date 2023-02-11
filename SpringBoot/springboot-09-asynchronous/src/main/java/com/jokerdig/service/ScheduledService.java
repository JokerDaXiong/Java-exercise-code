package com.jokerdig.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Joker大雄
 * @data 2022/7/30 - 10:38
 **/
@Service
@EnableScheduling
public class ScheduledService {


    // hello在特定的时间执行 cron计划任务
    // cron 表达式  可以通过在线生成指定的cron表达式
    // 秒 分 时 日 月 星期(0-7)
    // @Scheduled(cron = "30 57 10 * * ?")
    @Scheduled(cron = "0/2 * * * * ?") // 每两秒执行一次
    public void hello(){
        System.out.println("hello 现在被执行了");
    }
}
