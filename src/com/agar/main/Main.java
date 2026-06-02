package com.agar.main;

import javax.swing.JFrame;
import com.agar.ui.GamePanel;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Agar.io Patterns");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel panel = new GamePanel();

        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}