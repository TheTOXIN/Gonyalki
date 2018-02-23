package com.thetoxin.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Car {
    final int max_v = 100;
    final int max_top = 50;
    final int max_bot = 490;

    int Y;
    int dX;
    int dY;
    int layer_X1;
    int layer_X2;
    int v;
    int a;
    int s;
    int t;

    public Player() {
        img = new ImageIcon("res/car_mers.png").getImage();
        img_up = new ImageIcon("res/car_mers_l.png").getImage();
        img_down = new ImageIcon("res/car_mers_r.png").getImage();
        img_now = img;

        init();
    }

    public void init() {
        Y = 200;
        dX = 0;
        dY = 0;
        layer_X1 = 0;
        layer_X2 = 1280;
        v = 0;
        a = 0;
        s = 0;
        t = 0;
    }

    public Rectangle getRect() {
        return new Rectangle(X, Y, 300, 50);
    }

    public void move() {
        X = 0;
        s = s + v;
        Y = Y + dY;

        if (v < 0)
            v = 0;

        if (v > max_v) {
            a = 0;
            v = max_v;
        } else {
            v = v + a;
        }

        if (Y <= max_top)
            Y = max_top;
        if (Y >= max_bot)
            Y = max_bot;

        if (layer_X2 <= 0) {
            layer_X1 = 0;
            layer_X2 = 1300;
        } else {
            layer_X1 = layer_X1 - v;
            layer_X2 = layer_X2 - v;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            if (v == 0)
                dY = 0;
            else
                dY = -v / 5;
            img_now = img_up;
        }
        if (key == KeyEvent.VK_DOWN) {
            if (v == 0)
                dY = 0;
            else
                dY = v / 5;
            img_now = img_down;
        }
        if (key == KeyEvent.VK_RIGHT)
            a = 1;
        if (key == KeyEvent.VK_LEFT)
            a = -1;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dY = 0;
            img_now = img;
        }
        if (key == KeyEvent.VK_DOWN) {
            dY = 0;
            img_now = img;
        }
        if (key == KeyEvent.VK_RIGHT)
            a = 0;
        if (key == KeyEvent.VK_LEFT)
            a = 0;
    }
}
