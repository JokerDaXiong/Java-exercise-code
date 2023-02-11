package com.jokerdig.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author Joker大雄
 * @data 2022/8/1 - 13:07
 **/
@Service // 这里是spring包下的
public class UserService {
    // 获取provider-server里的内容
    @Reference // 远程引用 dubbo包下的
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("到注册中心拿到了："+ticket);
    }
}
