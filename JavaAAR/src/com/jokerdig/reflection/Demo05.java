package com.jokerdig.reflection;

/**
 * @author Joker大雄
 * @data 2021/9/9 - 18:14
 **/
public class Demo05 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemC = ClassLoader.getSystemClassLoader();
        System.out.println(systemC);

        //获取系统类加载器的父类加载器->扩展类加载器
        ClassLoader parent = systemC.getParent();
        System.out.println(parent);
        //获取扩展类的父类加载器->根加载器(C/C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader=Class.forName("com.jokerdig.reflection.Demo05").getClassLoader();
        System.out.println(classLoader);

        //测试当JDK内部类是哪个加载器加载的
        ClassLoader classLoader1=Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);
        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
