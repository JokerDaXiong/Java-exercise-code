package com.jokerdig.lesson3;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Joker大雄
 * @data 2021/8/17 - 23:43
 **/
//键盘
public class TestKeyboardListener {
    public static void main(String[] args) {
        new keyFrame();
    }
}
class keyFrame extends Frame{
    public keyFrame(){
        setBounds(1,2,500,300);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
          //键盘按压
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘按下的键
                int keycode = e.getKeyCode();
                System.out.println(keycode);
                //不需要可以去记录，使用VK_XX
                if(keycode==KeyEvent.VK_UP){
                    System.out.println("你按下了上键");
                }
            }
        });
    }
}