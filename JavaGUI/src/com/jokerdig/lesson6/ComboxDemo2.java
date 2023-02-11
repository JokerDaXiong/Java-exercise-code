package com.jokerdig.lesson6;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 12:01
 **/
public class ComboxDemo2 extends JFrame {
    public ComboxDemo2(){
        Container con = this.getContentPane();

        //列表框
        String[]arge = {"1：","2：","3："};
        JList jList = new JList(arge);
        con.add(jList);

        this.setVisible(true);
        this.setBounds(100,100,200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ComboxDemo2();
    }
}
