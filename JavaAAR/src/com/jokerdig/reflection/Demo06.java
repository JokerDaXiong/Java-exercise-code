package com.jokerdig.reflection;

import com.jokerdig.reflection.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Joker大雄
 * @data 2021/9/9 - 18:44
 **/
//获得类的信息
public class Demo06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.jokerdig.reflection.User");

        User user = new User();
        c1 = user.getClass();
        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名
        //获得类的属性
        System.out.println("------------");
        Field[] fields = c1.getFields();//只能找到public
        fields=c1.getDeclaredFields();//找到所有的属性
        for (Field field : fields) {
            System.out.println(field);
        }
        //获得指定属性
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        //获得类的方法
        System.out.println("------------");
        Method[] methods = c1.getMethods();//获得本类及其父类的全部public方法
        for(Method method :methods){
            System.out.println("正常的:"+method);
        }
        methods = c1.getDeclaredMethods();//获得本类的所有方法
        for(Method method :methods){
            System.out.println("getDeclaredMethods:"+method);
        }

        //获得指定方法
        //重载
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得指定的构造器
        System.out.println("------------");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }

        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            System.out.println("D:"+constructor);
        }

        //获得指定的构造器
        Constructor declaredConstructors = c1.getDeclaredConstructor(String.class, String.class,int.class);
        System.out.println("指定："+declaredConstructors);
    }
}
//User类
class User {
    private String name;
    public String password;
    private int age;

    public User() {
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}