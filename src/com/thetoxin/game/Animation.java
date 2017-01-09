package com.thetoxin.game;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Animation
{
    Player p;
    Road r;
    Image img_car = new ImageIcon("res/car_mers.png").getImage();
    Image img_car_l = new ImageIcon("res/car_mers_l.png").getImage();
    Image img_car_r = new ImageIcon("res/car_mers_r.png").getImage();
    Image img = img_car;
    Image img_enemy = new ImageIcon("res/car_nes.png").getImage();
    Image img_road = new ImageIcon("res/road.png").getImage();

    public void paint(Graphics g)
    {
        g = (Graphics2D) g;
        g.drawImage(img_road, p.layer_X1, 0, null);
        g.drawImage(img_road, p.layer_X2, 0, null);
        g.drawImage(p.img, p.X, p.Y, null);

        double v_now = (200/p.max_v) * p.v;
        g.setColor(Color.WHITE);
        Font font1 = new Font("Arial", Font.BOLD, 30);
        g.setFont(font1);
        g.drawString("СКОРОСТЬ - " + v_now + "км/ч", 10,680);

        Iterator<Enemy> i = r.enemyList.iterator();
        while (i.hasNext())
        {
            Enemy e = i.next();
            if (e.X >= 2000 || e.X <= -2000)
                i.remove();
            e.move();
            g.drawImage(img_enemy, e.X, e.Y, null);
        }
    }
}
