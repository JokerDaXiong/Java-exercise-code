package com.opp.demo08;

/**
 * @author Joker大雄
 * @data 2021/8/15 - 15:17
 **/
public class Test {
    public static void main(String[] args) {
        int a=1;
        int b=0;
        //捕获异常
        //finally不是必须的
        //捕获多个异常，从小到大
        //快捷键 Ctrl+Alt+T
        try{
            System.out.println(a/b);
        }catch (ArithmeticException e){ //catch里为想要捕获的异常最高为Throwable
            System.out.println("程序异常，变量b不能为0");
        }finally{
            System.out.println("finally");
        }

        try {
            new Test().test(1,0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常");
        }

    }

    //抛出异常
    public void test(int a,int b) throws Exception{
        if(b==0){
            throw new ArithmeticException();//主动抛出异常，一般在方法中使用
        }
    }
}
