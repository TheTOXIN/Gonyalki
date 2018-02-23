package com.thetoxin.game;

import java.awt.*;

public abstract class Car {
    Image img;
    Image img_now;
    Image img_up;
    Image img_down;
    int max_v;
    int max_top;
    int max_bot;
    int X;
    int Y;
    int dX;
    int dY;
    int V;
    int A;
    int S;
    int T;

    public abstract Rectangle getRect();
}
