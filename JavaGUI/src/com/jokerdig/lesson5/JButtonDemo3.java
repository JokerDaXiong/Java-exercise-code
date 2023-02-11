package com.jokerdig.lesson5;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 11:52
 **/
public class JButtonDemo3 extends JFrame {
    public JButtonDemo3(){
        Container con = this.getContentPane();
        //将图片变为图标
        URL url = JButtonDemo1.class.getResource("133.jpg");
        Icon icon = new ImageIcon(url);

       //多选框
        JCheckBox jCheckBox1 = new JCheckBox("Chebox1");
        JCheckBox jCheckBox2 = new JCheckBox("Chebox1");
        JCheckBox jCheckBox3 = new JCheckBox("Chebox1");

        con.add(jCheckBox1,BorderLayout.NORTH);
        con.add(jCheckBox2,BorderLayout.CENTER);
        con.add(jCheckBox3,BorderLayout.SOUTH);


        this.setVisible(true);
        this.setBounds(100,100,1001,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new JButtonDemo3();
    }

}
