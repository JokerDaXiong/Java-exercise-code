package com.jokerdig.lesson2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 21:39
 **/
public class TestText01 {
    public static void main(String[] args) {
        //启动
        new MyFrame();
    }
}

class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);
        //监听这个文本框输入的文字
        MyActionListener2 maction = new MyActionListener2();
        textField.addActionListener(maction);
        //设置替换编码
        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}

class MyActionListener2 implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        //获得一些资源
       TextField text1=(TextField) e.getSource();
       text1.getText();//获得输入框文本
        System.out.println(text1.getText());
        text1.setText("");
    }
}