package com.jokerdig.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jokerdig.pojo.Storage;
import com.jokerdig.mapper.StorageMapper;
import com.jokerdig.pojo.User;
import com.jokerdig.service.StorageService;
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
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    private StorageMapper storageMapper;
    // 自定义分页
    @Override
    public IPage<Storage> pageC(IPage<Storage> page, Wrapper wrapper) {
        return storageMapper.pageC(page,wrapper);
    }

}
