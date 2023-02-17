package com.jokerdig.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jokerdig.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-14
 */
public interface StorageService extends IService<Storage> {
    // 自定义分页查询
    IPage<Storage> pageC(IPage<Storage> page, Wrapper wrapper);
}
