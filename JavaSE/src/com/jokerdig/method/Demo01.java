package com.jokerdig.method;

/**
 * @author Joker大雄
 * @data 2021/8/12 - 19:32
 **/
public class Demo01 {
    //main
    public static void main(String[] args) {
      int sum=  add(1,2);//实际参数
      System.out.println(sum);
//        test();
    }
    //加法
    public static int add(int a,int b){//形式参数
        return a+b;
    }

    public static void test(){
        //练习2：用while或for循环输出1~1000之间能被5整除的数，并且每行输出3个
        for (int i = 0; i < 1000; i++) {
            if(i%5==0){
                System.out.print(i+"\t");
            }
            if(i%(5*3)==0){
                System.out.println();//换行
            }

        }
    }
}
