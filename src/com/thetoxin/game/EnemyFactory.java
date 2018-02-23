package com.thetoxin.game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class EnemyFactory {

    private ArrayList<Enemy> enemyList;

    public EnemyFactory() {
        enemyList = new ArrayList<>();
        this.init();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyList;
    }

    public void setEnemies(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public void init() {
        new Thread(() -> {
            Random rand = new Random();
            while (true) {
                try {
                    Thread.sleep(rand.nextInt(2000));
                    enemyList.add(new Enemy(1400, 50 + rand.nextInt(450), 10 + rand.nextInt(50)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean testCollisionWithEnemies(Player p) {
        Iterator<Enemy> i = enemyList.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (p.getRect().intersects(e.getRect())) {
                return true;
            }
        }

        return false;
    }
}
