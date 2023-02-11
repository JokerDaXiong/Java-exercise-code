package com.jokerdig;

import com.jokerdig.pojo.User;
import com.jokerdig.service.UserService;
import com.jokerdig.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07ShiroApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        User user = userService.queryUserByName("小王");
        System.out.println(user);

    }

}
