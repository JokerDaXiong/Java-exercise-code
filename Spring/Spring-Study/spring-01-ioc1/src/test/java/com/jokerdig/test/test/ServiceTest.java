package com.jokerdig.test.test;

import com.jokerdig.test.dao.UserDaoImpl;
import com.jokerdig.test.service.UserService;
import com.jokerdig.test.service.UserServiceImpl;

/**
 * @author Joker大雄
 * @data 2022/5/10 - 23:48
 **/
public class ServiceTest {

    public static void main(String[] args) {
       UserService userService = new UserServiceImpl();

        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
        userService.getService();
    }
}
