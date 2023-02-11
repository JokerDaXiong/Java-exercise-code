package com.jokerdig.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joker大雄
 * @data 2022/4/30 - 15:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    // 老师
    private Teacher teacher;
}
