package com.opp.demo09;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 15:39
 **/
public class Test {
    public static void main(String[] args) {
        try {
            test(11);
        } catch (MyException e) {
           // e.printStackTrace();
            //增加一些处理异常的代码
            System.out.println("MyException=>"+e);
        }
    }
    //可能会有异常的方法
    static void test(int a) throws MyException{
        System.out.println("传递的参数："+a);
      if(a>10){
          throw new MyException(a);//抛出
      }
        System.out.println("正常");
    }

}
