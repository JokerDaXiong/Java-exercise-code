package com.jokerdig.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author Joker大雄
 * @data 2022/8/1 - 13:00
 **/
// 服务注册与发现
@Service //dubbo的@service
@Component
public class TicketServiceImpl implements TicketService{

    @Override
    public String getTicket() {
        return "《jokerdig.com》";
    }
}
