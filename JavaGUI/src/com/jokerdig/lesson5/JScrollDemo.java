package com.jokerdig.lesson5;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 11:16
 **/
public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container con = this.getContentPane();

        //文本域
        JTextArea textarea = new JTextArea(20,30);
        textarea.setText("文本域");

        //Scroll面板
        JScrollPane jScrollPane = new JScrollPane(textarea);
        con.add(jScrollPane);

        this.setVisible(true);
        this.setBounds(100,100,100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
