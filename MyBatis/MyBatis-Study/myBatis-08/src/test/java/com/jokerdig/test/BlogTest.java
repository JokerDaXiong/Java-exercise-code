package com.jokerdig.test;

import com.jokerdig.mapper.BlogMapper;
import com.jokerdig.pojo.Blog;
import com.jokerdig.util.IDUtils;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/5/5 - 12:08
 **/
public class BlogTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        mapper.addBlog(new Blog(IDUtils.getID(),"测试博客标题","测试博主",new Date(),1000));

        sqlSession.close();
    }
    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        // 添加title改变查询结果
        map.put("author","JokerDaxiong");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        // 添加title改变查询结果
        map.put("author","JokerDaxiong");
        List<Blog> blogs = mapper.queryBlogChose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        // 添加title改变查询结果
        map.put("title","测试set");
        map.put("author","JokerDaxiong");
        map.put("id","3");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
