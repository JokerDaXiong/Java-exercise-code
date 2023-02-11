package com.jokerdig.service.bill;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.dao.bill.BillDao;
import com.jokerdig.dao.bill.BillDaoImp;
import com.jokerdig.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 12:25
 **/
public class BillServiceImpl implements BillService{

    // 引入dao
    private BillDao billDao;

    public BillServiceImpl() {
        billDao = new BillDaoImp();
    }

    // 查询所有订单
    @Override
    public List<Bill> getBillList(Bill bill) {
        Connection conn = null;
        List<Bill> billList = null;
        try {
            conn = BaseDao.getConnection();
            billList = billDao.getBillList(conn, bill);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return billList;
    }
    // 添加
    @Override
    public boolean add(Bill bill) {
        boolean flag = false;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//关闭自动提交
            int back = billDao.add(conn,bill);
            if(back>0){
                flag = true;
                conn.commit();
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            // 回滚
            System.out.println("---------rollback----------");
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
    // 删除
    @Override
    public boolean deleteBillById(String delId) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = BaseDao.getConnection();
            if (billDao.deleteBillById(conn, delId) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return flag;
    }
    // 通过id获取
    @Override
    public Bill getBillById(String id) {
        Bill bill = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            bill = billDao.getBillById(conn, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bill = null;
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return bill;
    }
    // 修改
    @Override
    public boolean modify(Bill bill) {
        boolean flag = false;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);// 关闭自动提交
            if(billDao.modify(conn,bill) > 0){
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
