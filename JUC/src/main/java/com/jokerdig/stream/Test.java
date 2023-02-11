package com.jokerdig.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author Joker大雄
 * @data 2022/8/25 - 10:37
 **/
public class Test {
    public static void main(String[] args) {
        User user1 = new User(1,"a",21);
        User user2 = new User(2,"b",27);
        User user3 = new User(3,"c",25);
        User user4 = new User(4,"d",24);
        User user5 = new User(7,"e",20);
        // 集合就是存储
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);

        // 计算交给流
        list.stream().
                // ID 为偶数
                filter(u->u.getId()%2==0).
                // 年龄大于 23
                filter(u->u.getAge()>23).
                // 用户名转换为大写字母
                map(u->{u.setName(u.getName().toUpperCase()); return u;}).
                //用户名倒着排序
                sorted((u1,u2)->u2.getName().compareTo(u1.getName())).
                // 只输出一个用户
                limit(1).
                forEach(System.out::println);
    }
}
