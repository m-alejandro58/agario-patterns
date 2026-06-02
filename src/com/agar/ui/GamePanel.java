package com.agar.ui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import com.agar.entities.Cell;
import com.agar.entities.Food;

import com.agar.factory.PlayerFactory;
import com.agar.input.MouseHandler;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private Thread gameThread;

    private Cell player;

    private List<Food> foods;

    public GamePanel() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        MouseHandler mouseHandler = new MouseHandler();
        addMouseMotionListener(mouseHandler);

        initializeGame();

        startGameThread();
    }

    private void initializeGame() {

        PlayerFactory playerFactory = new PlayerFactory();

        player = playerFactory.create();

        foods = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            double x = Math.random() * WIDTH;
            double y = Math.random() * HEIGHT;

            foods.add(new Food(x, y));
        }
    }

    private void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while (true) {

            update();

            repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {

        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        for (Food food : foods) {

            food.draw(g);
        }
    }
}