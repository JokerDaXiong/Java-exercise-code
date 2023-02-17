package com.jokerdig.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Goods;
import com.jokerdig.pojo.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-17
 */
public interface RecordService extends IService<Record> {
    // 自定义分页查询
    IPage<Record> pageC(IPage<Record> page, Wrapper wrapper);
}
