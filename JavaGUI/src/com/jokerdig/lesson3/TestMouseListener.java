package com.jokerdig.lesson3;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 23:06
 **/
public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");
    }

}
//自己的类
class MyFrame extends Frame {
    //创建ArrayList
    ArrayList points;
    //绘画需要监听鼠标位置

    //构造器
    public MyFrame(String title) {
        super(title);
        setBounds(200,200,300,300);

        //用数组存放鼠标的点
       points = new ArrayList<>();

       setVisible(true);

        //鼠标监听器，正对这个窗口
        this.addMouseListener(new MyMouseListener());
    }
    @Override
    public void paint(Graphics g){
        //画画需要监听鼠标,使用迭代器输出点Iterator
        Iterator iterator = points.iterator();
        while(iterator.hasNext()){
            Point point = (Point)iterator.next();
            g.setColor(Color.BLACK);
            g.fillOval(point.x,point.y,10,10);
        }
    }

    //添加一个点到界面
    public void addPoint(Point point){
        points.add(point);
    }

    //适配器模式
    private class MyMouseListener extends MouseAdapter{
        //鼠标 按下 弹起 按住不放

      //按压
        @Override
        public void mousePressed(MouseEvent e) {
           MyFrame frame=(MyFrame)e.getSource();
           //点击产生一个点,获取鼠标坐标画下点
            frame.addPoint(new Point(e.getX(),e.getY()));

            //每次点击重画一次
            frame.repaint();//刷新
        }
    }
}