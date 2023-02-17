package com.jokerdig.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.User;
import com.jokerdig.mapper.UserMapper;
import com.jokerdig.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    // 自动注入
    @Resource
    private UserMapper userMapper;
    // 自定义分页
    @Override
    public IPage<User> pageC(IPage<User> page, Wrapper wrapper) {
        return userMapper.pageC(page,wrapper);
    }
}
