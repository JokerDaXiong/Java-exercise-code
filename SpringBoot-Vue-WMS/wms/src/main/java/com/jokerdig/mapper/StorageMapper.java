package com.jokerdig.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jokerdig.pojo.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jokerdig.pojo.User;
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
public interface StorageMapper extends BaseMapper<Storage> {
    // 分页查询
    IPage<Storage> pageC(IPage<Storage> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
