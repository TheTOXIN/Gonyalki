package com.thetoxin.game;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame_1 = new JFrame("GovnoGonki");
        frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_1.setSize(1280,720);
        frame_1.add(new Road());
        frame_1.setVisible(true);
    }
}
