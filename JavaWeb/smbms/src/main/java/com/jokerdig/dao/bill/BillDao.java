package com.jokerdig.dao.bill;

import com.jokerdig.pojo.Bill;

import java.sql.Connection;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 11:09
 **/
public interface BillDao {
    // 查询订单列表
    List<Bill> getBillList(Connection connection, Bill bill) throws Exception;
    // 添加订单
    int add(Connection connection, Bill bill) throws Exception;

    // 删除订单
    int deleteBillById(Connection connection, String delId) throws Exception;


    // 通过id获取订单
    Bill getBillById(Connection connection, String id) throws Exception;

    // 修改订单信息
    int modify(Connection connection, Bill bill) throws Exception;

    // 根据供应商id查询订单
    int getBillCountByProviderId(Connection connection, String providerId) throws Exception;
}
