package com.jokerdig.test.service;

import com.jokerdig.test.dao.UserDao;

/**
 * @author Joker大雄
 * @data 2022/5/10 - 23:40
 **/
public class UserServiceImpl implements UserService{
    // 现在 更方便维护 思想上的转变
    private UserDao userDao;
    // 利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public void getService() {
        userDao.getUser();
    }
}
