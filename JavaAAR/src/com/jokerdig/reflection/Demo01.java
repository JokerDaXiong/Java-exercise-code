package com.jokerdig.reflection;

/**
 * @author Joker大雄
 * @data 2021/9/8 - 13:56
 **/
//测试Class类的创建方式
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        //方法一：通过对象获得
        Class cla1 = person.getClass();
        System.out.println(cla1.hashCode());
        //方法二：forName获得
        Class<?> cla2 = Class.forName("com.jokerdig.reflection.Student");
        System.out.println(cla2.hashCode());
        //方式三：通过类名.class获得
        Class cla3 = Student.class;
        System.out.println(cla3.hashCode());
        //方式四：基本内置类型的包装类都有一个Type属性
        Class<Integer> cla4= Integer.TYPE;
        System.out.println(cla4.hashCode());
        //获得父类类型
        Class cla5 = cla1.getSuperclass();
        System.out.println(cla5.hashCode());


    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name="学生";
    }
}
