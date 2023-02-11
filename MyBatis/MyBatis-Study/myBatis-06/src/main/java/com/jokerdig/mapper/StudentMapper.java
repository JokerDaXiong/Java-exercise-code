package com.jokerdig.mapper;

import com.jokerdig.pojo.Student;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/30 - 15:38
 **/
public interface StudentMapper {
    // 查询所有学生信息以及对应老师的信息
    List<Student> getStudent();
    List<Student> getStudent2();



}
