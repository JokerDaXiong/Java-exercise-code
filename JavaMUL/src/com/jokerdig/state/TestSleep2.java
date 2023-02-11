package com.jokerdig.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Joker大雄
 * @data 2021/8/21 - 14:02
 **/
//模拟倒计时
public class TestSleep2 {
    public static void main(String[] args) {
      //模拟倒计时
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());//获得当前时间

        try {
            while(true){
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());//更新时间
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException{
        int num =10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                System.out.println("时间结束");
                break;
            }
        }
    }
}
