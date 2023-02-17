package com.jokerdig.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jokerdig.pojo.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-16
 */
public interface GoodsService extends IService<Goods> {
    // 自定义分页查询
    IPage<Goods> pageC(IPage<Goods> page, Wrapper wrapper);
}
