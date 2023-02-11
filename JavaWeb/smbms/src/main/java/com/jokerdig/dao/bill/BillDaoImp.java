package com.jokerdig.dao.bill;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.pojo.Bill;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 11:11
 **/
public class BillDaoImp implements BillDao{

    // 查询订单列表
    @Override
    public List<Bill> getBillList(Connection conn, Bill bill) throws Exception {
        PreparedStatement ps =null;
        ResultSet re =null;
        List<Bill> billList = new ArrayList<>();
        if(conn!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select b.*,p.proName as providerName from smbms_bill b, smbms_provider p where b.providerId = p.id");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(bill.getProductName())) {
                sql.append(" and productName like ?");
                list.add("%" + bill.getProductName() + "%");
            }
            if (bill.getProviderId() > 0) {
                sql.append(" and providerId = ?");
                list.add(bill.getProviderId());
            }
            if (bill.getIsPayment() > 0) {
                sql.append(" and isPayment = ?");
                list.add(bill.getIsPayment());
            }
            Object[] para = list.toArray();
            re = BaseDao.execute(conn,ps,re,sql.toString(),para);
            while(re.next()){
                Bill _bill = new Bill();
                _bill.setId(re.getInt("id"));
                _bill.setBillCode(re.getString("billCode"));
                _bill.setProductName(re.getString("productName"));
                _bill.setProductDesc(re.getString("productDesc"));
                _bill.setProductUnit(re.getString("productUnit"));
                _bill.setProductCount(re.getBigDecimal("productCount"));
                _bill.setTotalPrice(re.getBigDecimal("totalPrice"));
                _bill.setIsPayment(re.getInt("isPayment"));
                _bill.setProviderId(re.getInt("providerId"));
                _bill.setProviderName(re.getString("providerName"));
                _bill.setCreationDate(re.getTimestamp("creationDate"));
                _bill.setCreatedBy(re.getInt("createdBy"));
                // 添加到list中
                billList.add(_bill);
            }
            // 释放资源
            BaseDao.closeResource(null,ps,re);
        }

        return billList;
    }
    // 添加订单
    @Override
    public int add(Connection conn, Bill bill) throws Exception {
        PreparedStatement ps = null;
        int back = 0;
        if(conn!=null){
            String sql = "insert into smbms_bill (billCode,productName,productDesc," +
                    "productUnit,productCount,totalPrice,isPayment,providerId,createdBy,creationDate)" +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] para = {bill.getBillCode(), bill.getProductName(), bill.getProductDesc(),
                    bill.getProductUnit(), bill.getProductCount(), bill.getTotalPrice(), bill.getIsPayment(),
                    bill.getProviderId(), bill.getCreatedBy(), bill.getCreationDate()};

            // 添加订单
            back = BaseDao.execute(conn,ps,sql,para);
            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }
        return back;
    }
    // 删除订单
    @Override
    public int deleteBillById(Connection conn, String delId) throws Exception {
        PreparedStatement ps =null;
        int back = 0;
        if(conn!=null){
            String sql = "delete from smbms_bill where id = ?";
            Object[] para = {delId};
            // 删除
            back = BaseDao.execute(conn,ps,sql,para);
            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }
        return back;
    }
    // 通过id获取订单
    @Override
    public Bill getBillById(Connection conn, String id) throws Exception {
        PreparedStatement ps =null;
        Bill bill = null;
        ResultSet re = null;
        if(conn!=null){
            String sql ="select b.*,p.proName as providerName from smbms_bill b, smbms_provider p where b.id=? and  b.providerId = p.id";
            Object[] para ={id};
            // 查询
            re = BaseDao.execute(conn,ps,re,sql,para);
            while(re.next()){
                bill = new Bill();
                bill.setId(re.getInt("id"));
                bill.setBillCode(re.getString("billCode"));
                bill.setProductName(re.getString("productName"));
                bill.setProductDesc(re.getString("productDesc"));
                bill.setProductUnit(re.getString("productUnit"));
                bill.setProductCount(re.getBigDecimal("productCount"));
                bill.setTotalPrice(re.getBigDecimal("totalPrice"));
                bill.setIsPayment(re.getInt("isPayment"));
                bill.setProviderId(re.getInt("providerId"));
                bill.setProviderName(re.getString("providerName"));
                bill.setModifyBy(re.getInt("modifyBy"));
                bill.setModifyDate(re.getTimestamp("modifyDate"));
            }
            // 释放资源
            BaseDao.closeResource(null,ps,re);
        }
        return bill;
    }
    // 修改订单信息
    @Override
    public int modify(Connection conn, Bill bill) throws Exception {
        PreparedStatement ps =null;
        int back = 0;
        if(conn!=null){
            String sql = "update smbms_bill set productName=?," +
                    "productDesc=?,productUnit=?,productCount=?,totalPrice=?," +
                    "isPayment=?,providerId=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] para = {bill.getProductName(), bill.getProductDesc(),
                    bill.getProductUnit(), bill.getProductCount(), bill.getTotalPrice(), bill.getIsPayment(),
                    bill.getProviderId(), bill.getModifyBy(), bill.getModifyDate(), bill.getId()};
            // 修改
            back = BaseDao.execute(conn,ps,sql,para);
            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }
        return back;
    }
    // 根据供应商id查询订单
    @Override
    public int getBillCountByProviderId(Connection conn, String providerId) throws Exception {
        PreparedStatement ps =null;
        int count = 0;
        if(conn!=null){
            String sql = "select count(1) as billCount from smbms_bill where providerId = ?";
            Object[] para = {providerId};
            // 查询
            count = BaseDao.execute(conn,ps,sql,para);
            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }

        return count;
    }
}
