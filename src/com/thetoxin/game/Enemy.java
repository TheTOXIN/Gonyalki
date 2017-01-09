package com.thetoxin.game;

import javax.swing.*;
import java.awt.*;

public class Enemy extends Car
{
    Road road;

    public Rectangle getRect()
    {
        return new Rectangle(X, Y+30, 400, 50);
    }

    public Enemy(int X, int Y, int V, Road road)
    {
        this.X = X;
        this.Y = Y;
        this.V = V;
        this.road = road;
        img = new ImageIcon("res/car_nes.png").getImage();
    }

    public void move ()
    {
        X = X - road.p.v + V;
    }
}
