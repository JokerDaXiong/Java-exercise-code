package com.jokerdig.lesson5;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 11:52
 **/
public class JButtonDemo2 extends JFrame {
    public JButtonDemo2(){
        Container con = this.getContentPane();
        //将图片变为图标
        URL url = JButtonDemo1.class.getResource("133.jpg");
        Icon icon = new ImageIcon(url);

        //单选框
        JRadioButton jRadioButton1 = new JRadioButton("JRadioButton1");
        JRadioButton jRadioButton2 = new JRadioButton("JRadioButton1");

        //由于单选框只能选择一个，分组
        ButtonGroup group =  new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        con.add(jRadioButton1,BorderLayout.NORTH);
        con.add(jRadioButton2,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setBounds(100,100,1001,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new  JButtonDemo2();
    }

}
