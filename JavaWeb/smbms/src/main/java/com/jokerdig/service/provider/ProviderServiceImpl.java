package com.jokerdig.service.provider;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.dao.bill.BillDao;
import com.jokerdig.dao.bill.BillDaoImp;
import com.jokerdig.dao.provider.ProviderDao;
import com.jokerdig.dao.provider.ProviderDaoImpl;
import com.jokerdig.pojo.Provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 12:24
 **/
public class ProviderServiceImpl implements ProviderService{

    private ProviderDao providerDao;
    private BillDao billDao;

    public ProviderServiceImpl() {
        providerDao = new ProviderDaoImpl();
        billDao = new BillDaoImp();
    }
    // 查询
    @Override
    public List<Provider> getProviderList(String proName, String proCode) {
        Connection conn = null;
        List<Provider> list = null;
        try {
            conn = BaseDao.getConnection();
            list = providerDao.getProviderList(conn,proName,proCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 释放资源
            BaseDao.closeResource(conn,null,null);
        }
        return list;
    }

    // 添加
    @Override
    public boolean add(Provider provider) {

        boolean flag = false;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//开启事务
            if (providerDao.add(conn, provider) > 0)
                flag = true;
                conn.commit(); // 提交
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                // 回滚
                System.out.println("---------rollback----------");
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            //释放资源 这里关闭Connection
            BaseDao.closeResource(conn, null, null);
        }
        return flag;
    }

    /*   删除
     * 业务：根据ID删除供应商表的数据之前，需要先去订单表里进行查询操作
     * 若订单表中无该供应商的订单数据，则可以删除
     * 若有该供应商的订单数据，则不可以删除
     * 返回值billCount
     * 1> billCount == 0  删除---1 成功 （0） 2 不成功 （-1）
     * 2> billCount > 0    不能删除 查询成功（0）查询不成功（-1）
     * ---判断
     * 如果billCount = -1 失败
     * 若billCount >= 0 成功
     */
    @Override
    public int deleteProviderById(String delId) {
        Connection conn = null;
        int billCount = -1; // 默认-1
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);// 开启事务
            billCount = billDao.getBillCountByProviderId(conn, delId);
            if (billCount == 0) {
                providerDao.deleteProviderById(conn, delId);
            }
            conn.commit();// 提交
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            billCount = -1;
            try {
                // 回滚
                System.out.println("---------rollback----------");
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }finally {
                BaseDao.closeResource(conn,null,null);
            }
        }
        return  billCount;
    }
    // 通过id查询供应商
    @Override
    public Provider getProviderById(String id) {
        Connection conn = null;
        Provider provider = null;
        try {
            conn = BaseDao.getConnection();
            provider = providerDao.getProviderById(conn,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return provider;
    }
    // 修改
    @Override
    public boolean modify(Provider provider) {
        boolean flag = false;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//关闭自动提交
            int back = providerDao.modify(conn,provider);
            if(back>0){
                flag = true;
                conn.commit();
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            // 失败后数据回滚
            System.out.println("数据回滚");
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            // 释放资源
            BaseDao.closeResource(conn,null,null);
        }
        return flag;
    }
}
