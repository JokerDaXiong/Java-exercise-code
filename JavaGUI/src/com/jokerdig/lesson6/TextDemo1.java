package com.jokerdig.lesson6;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 12:01
 **/
public class TextDemo1 extends JFrame {
    public TextDemo1(){
        Container con = this.getContentPane();

        //文本框
        JTextField text1 = new JTextField("hello");
        JTextField text2 = new JTextField("world");

        con.add(text1,BorderLayout.NORTH);
        con.add(text2,BorderLayout.SOUTH);


        this.setVisible(true);
        this.setBounds(100,100,200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextDemo1();
    }
}
