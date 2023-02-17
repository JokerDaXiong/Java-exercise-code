package com.jokerdig.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Goodstype;
import com.jokerdig.mapper.GoodstypeMapper;
import com.jokerdig.pojo.Storage;
import com.jokerdig.service.GoodstypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-14
 */
@Service
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodstypeService {
    @Autowired
    private GoodstypeMapper goodstypeMapper;
    // 自定义分页
    @Override
    public IPage<Goodstype> pageC(IPage<Goodstype> page, Wrapper wrapper) {
        return goodstypeMapper.pageC(page,wrapper);
    }

}
