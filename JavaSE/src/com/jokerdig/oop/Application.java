package com.jokerdig.oop;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 18:31
 **/
//一个项目应该只存在一个main方法
public class Application {
    public static void main(String[] args) {
      //方法重写
        A a = new A();
        a.test();
        //有继承关系后，父类的引用指向了子类
        B b = new A();
        b.test();


    }
}
/*
 //类：抽象的，实例化new
        Student student = new Student();
        Student student1 = new Student();

        student.name="小明";
        student.age=10;

        System.out.println(student.name);
        System.out.println(student.age);

        student1.name="小红";
        student1.age=9;
        System.out.println(student1.name);
        System.out.println(student1.age);

        //persons
          //实例化对象
       // Persons person = new Persons();
        Persons person = new Persons("有参构造");
        System.out.println(person.name);

        //内存简单讲解
           Pet dog = new Pet();
        dog.name="二狗";
        dog.age = 3;
        dog.shout();

        //封装
        Students st = new Students();
        st.setName("通过set赋值name");
        System.out.println(st.getName());
        //继承
           //继承
        Person01 per = new Person01();
        //name是persons中定义的
        // 当person01继承persons时也可使用其中公共的方法等
        per.name="222";
        System.out.println(per.name);
        //Java中所有的类都默认继承Object
        //super
        Person01 per = new Person01();
        per.test("main测试super");
 */
