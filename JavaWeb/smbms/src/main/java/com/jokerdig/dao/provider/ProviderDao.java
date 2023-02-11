package com.jokerdig.dao.provider;

import com.jokerdig.pojo.Provider;

import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 11:06
 **/
public interface ProviderDao {

    // 查询和分页
    List<Provider> getProviderList(Connection connection, String proName, String proCode) throws Exception;

    // 添加供应商
    int add(Connection connection, Provider provider) throws Exception;

    // 删除供应商
    int deleteProviderById(Connection connection, String delId) throws Exception;

    // 通过id获取供应商
    Provider getProviderById(Connection connection, String id) throws Exception;

    // 修改供应商
    int modify(Connection connection, Provider provider) throws Exception;
}
