package com.jokerdig.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jokerdig.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jokerdig.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-16
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    // 分页查询
    IPage<Goods> pageC(IPage<Goods> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
