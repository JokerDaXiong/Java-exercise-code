package com.jokerdig.test;

import com.jokerdig.mapper.StudentMapper;
import com.jokerdig.mapper.TeacherMapper;
import com.jokerdig.pojo.Student;
import com.jokerdig.pojo.Teacher;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/30 - 15:48
 **/
public class MapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.getTeacher(1);
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.getTeacher2(2);
        sqlSession.close();
    }
}
