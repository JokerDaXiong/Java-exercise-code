package com.jokerdig.mapper;

import com.jokerdig.pojo.User;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/4/23 - 15:37
 **/
public class UserMapperTest {
    // 查询所有
    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            // 获得sqlSession对象
            sqlSession = MyBatisUtil.getSqlSession();
            // 执行sql
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // mapper调用查询方法
            List<User> userList = mapper.getUserList();
            // 输出查询结果
            for (User user : userList) {
                System.out.println("id:"+user.getId()+" name:"+user.getName()+" 密码："+user.getPwd());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    // 根据ID查询
    @Test
    public void getUserById(){
        //获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查询id为1的用户
        User user = mapper.getUserById(1);
        // 输出
        System.out.println("id:"+user.getId()+" name:"+user.getName()+" 密码："+user.getPwd());
        // 关闭
        sqlSession.close();
    }
    // 添加
    @Test
    public void add(){
        // 获取sqlsession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 添加用户
        User user = new User(4,"王富贵","123");
        // 增删改需要提交事务
        int flag = mapper.add(user);
        if(flag>0){
            System.out.println("添加成功"+user);
            // 提交事务
            sqlSession.commit();
        }else{
            System.out.println("添加失败");
        }
        //关闭
        sqlSession.close();
    }
    // 修改
    @Test
    public void update(){
        // 获取sqlsession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 修改用户
        User user = new User(4,"王小胖","333");
        int flag = mapper.update(user);
        if(flag>0){
            System.out.println("修改成功"+user);
            // 增删改需要提交事务
            sqlSession.commit();
        }else{
            System.out.println("修改失败");
        }
        //关闭
        sqlSession.close();
    }
    // 删除
    @Test
    public void delete (){
        // 获取sqlsession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 删除用户 删除id为4的用户
        int flag = mapper.delete(4);
        if(flag>0){
            System.out.println("删除成功");
            // 提交事务
            sqlSession.commit();
        }else{
            System.out.println("删除失败");
        }
        // 关闭
        sqlSession.close();
    }
//    使用map添加
    @Test
    public void addMap(){
        // 获取sqlsession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 执行
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 使用map添加
        Map<String,Object> userMap = new HashMap<String, Object>();
        userMap.put("uid",6);
        userMap.put("username","小笨蛋");
        userMap.put("password","xbd123");
        int flag=mapper.addMap(userMap);
        if(flag>0){
            System.out.println("添加成功");
            // 提交事务
            sqlSession.commit();
        }else{
            System.out.println("添加失败");
        }
        // 关闭
        sqlSession.close();
    }
}
