package com.jokerdig.dao.provider;

import com.jokerdig.dao.BaseDao;
import com.jokerdig.pojo.Provider;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/20 - 11:06
 **/
public class ProviderDaoImpl implements ProviderDao{


    // 查询和分页
    @Override
    public List<Provider> getProviderList(Connection conn, String proName, String proCode) throws Exception {
        PreparedStatement ps = null;
        ResultSet re = null;
        List<Provider> providerList = new ArrayList<>();
        if(conn!=null){
            // 编写查询
            StringBuffer sql = new StringBuffer();
            sql.append("select * from smbms_provider where 1=1 ");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(proName)) {
                sql.append(" and proName like ?");
                list.add("%" + proName + "%");
            }
            if (!StringUtils.isNullOrEmpty(proCode)) {
                sql.append(" and proCode like ?");
                list.add("%" + proCode + "%");
            }
            Object[] params = list.toArray();
            re = BaseDao.execute(conn, ps, re, sql.toString(), params);
            //遍历查询结果
            while(re.next()){
                Provider provider = new Provider();
                provider.setId(re.getInt("id"));
                provider.setProCode(re.getString("proCode"));
                provider.setProName(re.getString("proName"));
                provider.setProDesc(re.getString("proDesc"));
                provider.setProContact(re.getString("proContact"));
                provider.setProPhone(re.getString("proPhone"));
                provider.setProAddress(re.getString("proAddress"));
                provider.setProFax(re.getString("proFax"));
                provider.setCreationDate(re.getTimestamp("creationDate"));
                // 添加到list中
                providerList.add(provider);
            }
            // 释放资源
            BaseDao.closeResource(null,ps,re);
        }

        return providerList;
    }

    // 添加供应商
    @Override
    public int add(Connection conn, Provider provider) throws Exception {
        PreparedStatement ps = null;
        int back = 0;
        if(conn!=null){
            String sql ="insert into smbms_provider (proCode,proName,proDesc," +
                    "proContact,proPhone,proAddress,proFax,createdBy,creationDate)" +
                    "values(?,?,?,?,?,?,?,?,?)";
            Object[] para = {provider.getProCode(), provider.getProName(), provider.getProDesc(),
                    provider.getProContact(), provider.getProPhone(), provider.getProAddress(),
                    provider.getProFax(), provider.getCreatedBy(), provider.getCreationDate()};
            // 添加
            back = BaseDao.execute(conn,ps,sql,para);

            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }
        return back;
    }
    // 删除供应商
    @Override
    public int deleteProviderById(Connection conn, String delId) throws Exception {
        PreparedStatement ps = null;
        int back = 0;
        if(conn!=null){
            String sql = "delete from smbms_provider where id = ? ";
            Object[] para = {delId};
            back = BaseDao.execute(conn,ps,sql,para);
            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }
        return back;
    }
    // 通过id获取供应商
    @Override
    public Provider getProviderById(Connection conn, String id) throws Exception {
        PreparedStatement ps = null;
        ResultSet re = null;
        Provider provider = null;
        if(conn!=null){
            String sql = "select * from smbms_provider where id=?";
            Object[] para = {id};
            // 查询
            re = BaseDao.execute(conn,ps,re,sql,para);
            while(re.next()){
                provider = new Provider();
                provider.setId(re.getInt("id"));
                provider.setProCode(re.getString("proCode"));
                provider.setProName(re.getString("proName"));
                provider.setProDesc(re.getString("proDesc"));
                provider.setProContact(re.getString("proContact"));
                provider.setProPhone(re.getString("proPhone"));
                provider.setProAddress(re.getString("proAddress"));
                provider.setProFax(re.getString("proFax"));
                provider.setCreatedBy(re.getInt("createdBy"));
                provider.setCreationDate(re.getTimestamp("creationDate"));
                provider.setModifyBy(re.getInt("modifyBy"));
                provider.setModifyDate(re.getTimestamp("modifyDate"));
            }
            // 释放资源
            BaseDao.closeResource(null,ps,re);
        }
        return provider;
    }
    // 修改供应商
    @Override
    public int modify(Connection conn, Provider provider) throws Exception {
        PreparedStatement ps = null;
        int back = 0;
        if(conn!=null){
            String sql = "update smbms_provider set proName=?,proDesc=?,proContact=?," +
                    "proPhone=?,proAddress=?,proFax=?,modifyBy=?,modifyDate=? where id = ?";
            Object[] para = {provider.getProName(), provider.getProDesc(), provider.getProContact(), provider.getProPhone(), provider.getProAddress(),
                    provider.getProFax(), provider.getModifyBy(), provider.getModifyDate(), provider.getId()};
            // 修改
            back = BaseDao.execute(conn,ps,sql,para);
            // 释放资源
            BaseDao.closeResource(null,ps,null);
        }

        return back;
    }
}
