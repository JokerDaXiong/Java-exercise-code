package com.jokerdig.service.provider;

import com.jokerdig.pojo.Provider;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 12:24
 **/
public interface ProviderService {

    // 供应商分页查询
    public List<Provider> getProviderList(String proName, String proCode);

    // 添加供应商
    public boolean add(Provider provider);

    // 删除供应商
    public int deleteProviderById(String delId);

    // 通过proId获取供应商

    public Provider getProviderById(String id);

    // 修改供应商
    public boolean modify(Provider provider);
}
