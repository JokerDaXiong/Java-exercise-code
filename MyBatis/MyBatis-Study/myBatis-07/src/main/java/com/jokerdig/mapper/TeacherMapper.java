package com.jokerdig.mapper;

import com.jokerdig.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author Joker大雄
 * @data 2022/4/30 - 15:38
 **/
public interface TeacherMapper {

    // 获取指定老师下所有学生的信息
    Teacher getTeacher(@Param("tid") int id);
    Teacher getTeacher2(@Param("tid") int id);
}
