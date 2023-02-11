package com.jokerdig.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author Joker大雄
 * @data 2021/9/11 - 20:13
 **/
//练习反射操作注解
public class Demo10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.jokerdig.reflection.Student1");
        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解value的值
        Stu annotation = (Stu) c1.getAnnotation(Stu.class);
        String value = annotation.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FieldStu annotation1 = name.getAnnotation(FieldStu.class);
        System.out.println(annotation1.colunName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
    }
}
@Stu("db_student")
class Student1{
    @FieldStu(colunName = "db_id",type = "int",length = 10)
    private int id;
    @FieldStu(colunName = "db_age",type = "int",length = 10)
    private int age;
    @FieldStu(colunName = "db_name",type = "varchar",length = 3)
    private String name;

    public Student1() {
    }

    public Student1(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface  Stu{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldStu{
    String colunName();
    String type();
    int length();
}