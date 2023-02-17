package com.jokerdig.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Goods;
import com.jokerdig.mapper.GoodsMapper;
import com.jokerdig.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-16
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public IPage<Goods> pageC(IPage<Goods> page, Wrapper wrapper) {
        return goodsMapper.pageC(page,wrapper);
    }
}
