package com.jokerdig.lesson1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:54
 **/
public class Demo {
    public static void main(String[] args) {
        //总布局
        Frame frame = new Frame("练习");
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(400,300);
        frame.setLocation(300,400);
        frame.setBackground(new Color(1,1,1));
        frame.setVisible(true);
        //4个面板
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

        //第一个面板
        p1.add(new Button("East-1"),BorderLayout.EAST);
        p1.add(new Button("West-2"),BorderLayout.WEST);
        //第二个面板
        p2.add(new Button("2-btn-1"));
        p2.add(new Button("2-btn-2"));

        //p2放到p1中间
        p1.add(p2,BorderLayout.CENTER);


        //第三个面板
        p3.add(new Button("East-3"),BorderLayout.EAST);
        p3.add(new Button("West-4"),BorderLayout.WEST);

        //第四个面板
        for (int i = 1; i <= 4; i++) {
            p4.add(new Button("for-"+i));
        }
        //p4放到p3中
        p3.add(p4,BorderLayout.CENTER);

        //将面板放入frame
        frame.add(p1);
        frame.add(p3,BorderLayout.SOUTH);

        //结束监听
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //结束
                System.exit(0);
            }
        });
    }
}
