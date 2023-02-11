package com.jokerdig.lesson1;

import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:47
 **/
//表格布局
public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("表格布局");

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4= new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");

        frame.setLayout(new GridLayout(3,2));
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

        frame.pack();//java函数，自动最优
        frame.setVisible(true);
    }
}
