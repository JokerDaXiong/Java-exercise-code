package com.jokerdig.lesson4;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 9:52
 **/
public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJframe2().init();
    }
}
class MyJframe2 extends JFrame{
    public void init(){
        this.setVisible(true);
        this.setBounds(100,100,100,100);
        JLabel label = new JLabel("这是Jlabel");
        this.add(label);
        //设置水平对齐
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //获得容器
       Container container =this.getContentPane();
       container.setBackground(Color.pink);
        //关闭事件
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
