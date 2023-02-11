package com.opp;

import com.opp.demo01.A;
import com.opp.demo01.B;
import com.opp.demo02.Person;
import com.opp.demo02.Student;
import com.opp.demo02.Teacher;
import com.opp.demo06.Outer;

/**
 * @author Joker大雄
 * @data 2021/8/14 - 18:31
 **/
//一个项目应该只存在一个main方法
public class Application {
    public static void main(String[] args) {


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

         //方法重写
        A a = new A();
        a.test();
        //有继承关系后，父类的引用指向了子类
        B b = new A();
        b.test();

        //多态

          //一个对象的实际类型是确定的
        //new Student();
        //new Person();

        //可以只想的引用类型就不确定了

        //子类能调用的方法都是自己的或者继承父类的
        Student s1 = new Student();
        //person父类性，可以指向子类，但不能调用子类独有的方法
        Person s2 = new Student();
        Object s3 = new Student();

        s2.run();//子类重写父类的方法，执行子类的方法
        s1.run();

        s1.eat();
        //s2.eat();

         //instandeof
        Object object = new Student();
        //能否编译通过主要看X与Y有无父子关系
       // System.out.println(X instanceof Y);

        System.out.println(object instanceof Student);//true
        System.out.println(object instanceof Person);//true
        System.out.println(object instanceof Person);//true
        System.out.println(object instanceof Teacher);//false
        System.out.println(object instanceof String);//false

        Person perosn = new Person();
        System.out.println("=============================");
        System.out.println(perosn instanceof Student);//true
        System.out.println(perosn instanceof Person);//true
        System.out.println(perosn instanceof Person);//true
        System.out.println(perosn instanceof Teacher);//false
       // System.out.println(perosn instanceof String);//编译报错

        Student student = new Student();
        System.out.println("=============================");
        System.out.println(student instanceof Student);//true
        System.out.println(student instanceof Person);//true
        System.out.println(student instanceof Person);//true
       // System.out.println(student instanceof Teacher);//编译报错
       // System.out.println(student instanceof String);//编译报错

       //类型转换
         //类型之间的转换  父  子
        //高                   低
        Person student = new Student();

        //student将这个对象转换为Student类型，我们就可以使用Student类型

        ((Student)student).go();

        //子类转化为父类，可能丢失自己本来的方法
        Student student1 = new Student();
        student1.go();
        Person perosn = student1;

        //内部类

        Outer out = new Outer();
        //通过这个外部类来实例化内部类
        Outer.Inner inner =out.new Inner();
        inner.in();




 */
