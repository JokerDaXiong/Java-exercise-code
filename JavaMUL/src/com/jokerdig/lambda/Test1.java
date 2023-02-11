package com.jokerdig.lambda;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 12:52
 **/
//lambda表达式
public class Test1 {
    //3.静态内部类
    static class Like2 implements Likes{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {

        Likes like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements Likes{

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        //调用
        new Like3().lambda();

        //5.匿名内部类
        like = new Likes(){

            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();
        //6.用lambda简化
        like = ()->{
            System.out.println("I like Lambda5");
        };
        like.lambda();
    }
}

//1.定义一个函数式接口
interface Likes{
    void lambda();
}
//2.实现类
class Like implements Likes{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}