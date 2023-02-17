package com.jokerdig.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jokerdig.pojo.Goodstype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-14
 */
@Mapper
public interface GoodstypeMapper extends BaseMapper<Goodstype> {
    IPage<Goodstype> pageC(IPage<Goodstype> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
