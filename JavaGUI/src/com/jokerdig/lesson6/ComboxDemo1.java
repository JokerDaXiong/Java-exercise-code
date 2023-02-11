package com.jokerdig.lesson6;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 12:01
 **/
public class ComboxDemo1 extends JFrame {
    public ComboxDemo1(){
        Container con = this.getContentPane();

        //下拉框
        JComboBox jComboBox = new JComboBox();

        jComboBox.addItem(null);
        jComboBox.addItem("正字热映");
        jComboBox.addItem("即将下架");
        jComboBox.addItem("已下架");
        con.add(jComboBox);

        this.setVisible(true);
        this.setBounds(100,100,200,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ComboxDemo1();
    }
}
