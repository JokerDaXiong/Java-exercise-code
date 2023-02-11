package com.jokerdig.mapper;

import com.jokerdig.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * @author Joker大雄
 * @data 2022/5/5 - 12:12
 **/
public interface BlogMapper {
    // 测试添加
    @Insert("insert into blog(id,title,author,create_time,views) values(#{id},#{title},#{author},#{createTime},#{views})")
    int addBlog(Blog blog);
    // 查询博客
    List<Blog> queryBlogIF(Map map);
    // 查询 chose
    List<Blog> queryBlogChose(Map map);
    // 更新博客 使用set标签
    int updateBlog(Map map);
    // 查询 id 为 123的信息 使用foreach
    List<Blog> queryBlogForEach(Map map);
}
