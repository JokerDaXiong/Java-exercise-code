package com.jokerdig.test;

import com.jokerdig.mapper.StudentMapper;
import com.jokerdig.pojo.Student;
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
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudent();
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudent2();
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
