package com.jokerdig.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/4/30 - 15:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private int id;
    private String name;
    // 一对多 一个老师有多个学生
    private List<Student> students;
}
