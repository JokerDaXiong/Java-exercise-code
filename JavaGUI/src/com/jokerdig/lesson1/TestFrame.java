package com.jokerdig.lesson1;

import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:01
 **/
//GUI的第一个界面
public class TestFrame {
    public static void main(String[] args) {
        //Frame
        Frame frame=new Frame("我的第一个Java图像界面窗口");
        //需要设置可见性
        frame.setVisible(true);
        //设置窗口大小
        frame.setSize(400,400);
        //设置背景颜色
        frame.setBackground(new Color(14, 14, 14));
        //弹出初始位置
        frame.setLocation(300,300);
        //设置大小固定
        frame.setResizable(false);
    }

}
