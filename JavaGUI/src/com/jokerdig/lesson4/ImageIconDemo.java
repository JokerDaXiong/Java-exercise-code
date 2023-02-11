package com.jokerdig.lesson4;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 10:49
 **/
public class ImageIconDemo extends JFrame {
    public ImageIconDemo(){
        //获取图片地址
        JLabel label = new JLabel("imageIcon");
        URL url=ImageIconDemo.class.getResource("1.jpg");

        ImageIcon imageIcon=new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Container con = getContentPane();
        con.add(label);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,200,200);
    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
