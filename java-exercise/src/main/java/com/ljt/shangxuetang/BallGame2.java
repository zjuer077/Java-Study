package com.ljt.shangxuetang;

import javax.swing.*;
import java.awt.*;

public class BallGame2 extends JFrame {
    Image ball = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ljt\\Desktop/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ljt\\Desktop/desk.jpg");
    double x = 100;
    double y = 100;
    double degree = 3.14/3;
    @Override
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次！");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int) x,(int) y,null);

        x = x + 10* Math.cos(degree);
        y = y + 10* Math.sin(degree);
        if(y > 500 - 40 - 30||y < 40 + 40){
            degree = - degree;
        }
        if(x < 40 + 30 || x >856 - 40 - 30){
            degree = 3.14 - degree;
        }
    }


    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);

        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
    public static void main(String[] args) {
        BallGame2 game = new BallGame2();
        game.launchFrame();
    }
}
