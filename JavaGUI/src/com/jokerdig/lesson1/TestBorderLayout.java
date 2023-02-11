package com.jokerdig.lesson1;

import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/16 - 16:42
 **/
//东西南北中布局
public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("东西南北中布局");

        Button east = new Button("East");
        Button west = new Button("West");
        Button south = new Button("South");
        Button north = new Button("North");
        Button center = new Button("Center");

        frame.add(east,BorderLayout.EAST);
        frame.add(west,BorderLayout.WEST);
        frame.add(south,BorderLayout.SOUTH);
        frame.add(north,BorderLayout.NORTH);
        frame.add(center,BorderLayout.CENTER);

        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
