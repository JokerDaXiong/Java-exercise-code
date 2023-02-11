package com.jokerdig.lesson4;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joker大雄
 * @data 2021/8/18 - 10:29
 **/
//图标，需要实现类，Frame继承

public class IconDemo extends JFrame implements Icon {

    private int width;
    private int height;


    public IconDemo(){};
    public IconDemo(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void init(){
        IconDemo icon = new IconDemo(10,10);
        //图标放在标签或按钮
        JLabel label=new JLabel("icontest",icon,SwingConstants.CENTER);

        Container cont = getContentPane();
        cont.add(label);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }
    @Override
    public int getIconHeight() {
        return this.height;
    }
    public static void main(String[] args) {
        new IconDemo().init();
    }
}
