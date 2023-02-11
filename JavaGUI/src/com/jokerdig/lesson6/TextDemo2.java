package com.jokerdig.lesson6;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 12:01
 **/
public class TextDemo2 extends JFrame {
    public TextDemo2(){
        Container con = this.getContentPane();

        //密码框
        JPasswordField text1 = new JPasswordField("输入密码");

        JPasswordField text2 = new JPasswordField("world");
        //也可以自定义隐藏样式,默认是·
        text2.setEchoChar('*');
        con.add(text1,BorderLayout.NORTH);
        con.add(text2,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setBounds(100,100,200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextDemo2();
    }
}
