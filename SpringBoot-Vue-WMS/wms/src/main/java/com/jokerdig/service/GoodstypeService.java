package com.jokerdig.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jokerdig.pojo.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-14
 */
public interface GoodstypeService extends IService<Goodstype> {
    IPage<Goodstype> pageC(IPage<Goodstype> page, Wrapper wrapper);
}
