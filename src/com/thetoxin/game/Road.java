package com.thetoxin.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Road extends JPanel implements ActionListener,Runnable
{
    Image img_road = new ImageIcon("res/road.png").getImage();
    Timer t = new Timer(20, this);
    Player p = new Player();
    Thread enemiesFactory = new Thread(this);
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    public Road()
    {
        t.start();
        enemiesFactory.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
    }

    private class myKeyAdapter extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e)
        {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img_road, p.layer_X1, 0, null);
        g2.drawImage(img_road, p.layer_X2, 0, null);
        g2.drawImage(p.img_now, p.X, p.Y, null);

        double v_now = (200/p.max_v) * p.v;
        g2.setColor(Color.WHITE);
        Font font1 = new Font("Arial", Font.BOLD, 30);
        g2.setFont(font1);
        g2.drawString("СКОРОСТЬ - " + v_now + "км/ч", 10,680);

        Iterator<Enemy> i = enemyList.iterator();
            while (i.hasNext())
            {
                Enemy e = i.next();
            if (e.X >= 2000 || e.X <= -2000)
                i.remove();
            e.move();
            g2.drawImage(e.img, e.X, e.Y, null);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        p.move();
        repaint();
        testCollisionWithEnemies();
    }

    private void testCollisionWithEnemies()
    {
        Iterator<Enemy> i = enemyList.iterator();
        while(i.hasNext())
        {
            Enemy e = i.next();
            if (p.getRect().intersects(e.getRect()))
            {
                JOptionPane.showMessageDialog(null, "ВСЁ ОЧЕНЬ ПЛОХО \n" + "Ты проехал: "+p.s/10000+"км" );
                System.exit(1);
            }
        }
    }
    public void run()
    {
        while(true)
        {
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));
                enemyList.add(new Enemy(1400, 50 + rand.nextInt(450), 10 + rand.nextInt(50), this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
