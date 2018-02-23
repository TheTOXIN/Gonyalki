package com.thetoxin.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends Car {

    private Random random;

    public Rectangle getRect() {
        return new Rectangle(X, Y + 30, 400, 50);
    }

    public Enemy(int X, int Y, int V) {
        this.X = X;
        this.Y = Y;
        this.V = V;
        this.random = new Random();
        this.img = new ImageIcon("res/car_nes.png").getImage();
    }

    public void move(Player p) {
        X = X - p.v + V;
    }
}
