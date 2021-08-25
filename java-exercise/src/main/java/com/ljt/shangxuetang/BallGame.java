package com.ljt.shangxuetang;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {
    Image ball = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ljt\\Desktop/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ljt\\Desktop/desk.jpg");
    double x = 100;
    double y = 100;
    boolean right = true;
    @Override
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次！");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int) x,(int) y,null);

        if (right){
            x = x + 10;

        }else {
            x = x - 10;
        }
        if(x > 856 - 40 - 30){
            right = false;
        }
        if(x < 40){
            right = true;
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
        BallGame game = new BallGame();
        game.launchFrame();
    }
}
