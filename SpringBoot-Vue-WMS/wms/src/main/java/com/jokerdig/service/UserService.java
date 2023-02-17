package com.jokerdig.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-03
 */
public interface UserService extends IService<User> {
    // 自定义分页查询
    IPage<User> pageC(IPage<User> page, Wrapper wrapper);
}
