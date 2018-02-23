package com.thetoxin.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Road extends JPanel implements ActionListener {

    private Timer t;
    private Player p;
    private MyKeyAdapter key;
    private EnemyFactory factory;
    private Animation anim;

    public Road() {
        p = new Player();
        t = new Timer(20, this);
        key = new MyKeyAdapter(p);
        factory = new EnemyFactory();
        anim = new Animation();

        t.start();
        addKeyListener(key);
        setFocusable(true);
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public EnemyFactory getFactory() {
        return factory;
    }

    public void setFactory(EnemyFactory factory) {
        this.factory = factory;
    }

    public void restart() {
        p.init();
        factory.getEnemies().clear();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        anim.paint(p, factory.getEnemies(), g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();

        if (factory.testCollisionWithEnemies(p)) {
            JOptionPane.showMessageDialog(null, "ВСЁ ОЧЕНЬ ПЛОХО \n" + "Ты проехал: " + p.s / 10000 + "км");
            restart();
        }

        repaint();
    }
}
