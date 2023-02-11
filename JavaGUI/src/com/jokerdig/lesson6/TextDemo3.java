package com.jokerdig.lesson6;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 12:01
 **/
public class TextDemo3 extends JFrame {
    public TextDemo3(){
        Container con = this.getContentPane();

        //文本域
        JTextArea text1 = new JTextArea(20,30);

        text1.setText("文本域");
        //通过面板显示
        JScrollPane jScrollPane = new JScrollPane(text1);
        con.add(jScrollPane);

        this.setVisible(true);
        this.setBounds(100,100,200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextDemo3();
    }
}
