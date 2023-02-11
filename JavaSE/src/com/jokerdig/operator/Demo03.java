package com.jokerdig.operator;

/**
 * @author Joker大雄
 * @data 2021/8/10 - 20:29
 **/
public class Demo03 {
    public static void main(String[] args) {
        //逻辑运算符
        //  与&  或|  非!
        boolean a = true;
        boolean b = false;

        System.out.println("a && b:"+(a&&b));
        System.out.println("a || b:"+(a||b));
        System.out.println("!(a&&b):"+!(a&&b));

        //短路运算
        int c = 5;
        boolean d = (c<4)&&(c++<4);
        System.out.println(d);
        System.out.println(c);

        //位运算符
        /*
          A = 0011 1100;
          B = 0000 1101;

          A&B = 0000 1100;
          A/B = 0011 1101;
          A^B = 0011 0001
          ~B  = 1111 0010

          2*8 = 16   2*2*2*2
          <<左移  *2
          >>右移  /2
          0000 0000   0
          0000 0001   1
          0000 0010   2
          0000 0011   3
          0000 0100   4
          0000 1000   8
          0001 0000   16
         */
    }
}
