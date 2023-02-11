package com.jokerdig.lesson1;

import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:11
 **/
//窗口封装
public class TestFrame1 {
    public static void main(String[] args) {
        //展示多个窗口
        new MyFrame(300,300,300,400, Color.BLUE);
        new MyFrame(600,300,300,400, Color.YELLOW);
        new MyFrame(300,600,300,400, Color.BLACK);
        new MyFrame(600,600,300,400, Color.PINK);
    }
}
//窗口类
class MyFrame extends Frame{

    static int id=0;//可能有多个窗口
    public MyFrame(int x,int y,int w,int h,Color color){
        super("MyFrame"+(++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
