package com.jokerdig.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Joker大雄
 * @data 2022/7/29 - 13:08
 **/
@Service
public class AsyncService {
    @Async // 这是一个异步任务
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理...");
    }
}
