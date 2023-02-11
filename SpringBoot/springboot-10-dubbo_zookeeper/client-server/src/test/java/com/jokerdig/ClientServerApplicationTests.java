package com.jokerdig;

import com.jokerdig.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientServerApplicationTests {

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
        userService.buyTicket();
    }

}
