package com.jokerdig.lesson5;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 11:11
 **/
public class JPanelDemo extends JFrame {

    public JPanelDemo(){
        Container con = this.getContentPane();
        con.setLayout(new GridLayout(2,1,10,10));//有间距

        JPanel jp = new JPanel(new GridLayout(1,3));
        JPanel jp2 = new JPanel(new GridLayout(1,2));
        JPanel jp3 = new JPanel(new GridLayout(3,1));
        jp.add(new JButton("1"));
        jp.add(new JButton("2"));
        jp.add(new JButton("3"));
        jp2.add(new JButton("2"));
        jp2.add(new JButton("3"));
        jp3.add(new JButton("2"));
        jp3.add(new JButton("3"));

        con.add(jp);
        con.add(jp2);
        con.add(jp3);
        this.setVisible(true);
        this.setBounds(100,100,100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
