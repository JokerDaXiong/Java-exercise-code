package com.jokerdig.lesson5;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 11:28
 **/
public class JButtonDemo1 extends JFrame {
    public JButtonDemo1(){
        Container con = this.getContentPane();
        //将图片变为图标
        URL url = JButtonDemo1.class.getResource("133.jpg");
        Icon icon = new ImageIcon(url);

        //把这个图标放在按钮
        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");

        con.add(button);
        this.setVisible(true);
        this.setBounds(100,100,1001,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new  JButtonDemo1();
    }

}
