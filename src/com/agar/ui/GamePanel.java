package com.agar.ui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.agar.entities.Cell;
import com.agar.entities.Food;
import com.agar.entities.PowerUp;

import com.agar.factory.PlayerFactory;
import com.agar.input.MouseHandler;

import com.agar.services.CollisionService;

import com.agar.decorator.SpeedBoostDecorator;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private Thread gameThread;

    private Cell player;

    private List<Food> foods;

    private int score;

    private PowerUp speedPowerUp;

    private long speedBoostEndTime = 0;

    public GamePanel() {

        setPreferredSize(
                new Dimension(WIDTH, HEIGHT));

        setBackground(Color.BLACK);

        MouseHandler mouseHandler =
                new MouseHandler();

        addMouseMotionListener(mouseHandler);

        initializeGame();

        startGameThread();
    }

    private void initializeGame() {

        PlayerFactory playerFactory =
                new PlayerFactory();

        player = playerFactory.create();

        foods = new ArrayList<>();

        score = 0;

        for (int i = 0; i < 20; i++) {

            double x = Math.random() * WIDTH;
            double y = Math.random() * HEIGHT;

            foods.add(new Food(x, y));
        }

        spawnSpeedPowerUp();
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

        checkFoodCollisions();

        checkPowerUpCollision();

        updatePowerUps();
    }

    private void checkFoodCollisions() {

        int foodsToSpawn = 0;

        Iterator<Food> iterator =
                foods.iterator();

        while (iterator.hasNext()) {

            Food food = iterator.next();

            if (CollisionService.isColliding(
                    player,
                    food
            )) {

                iterator.remove();

                player.grow(1);

                score++;

                foodsToSpawn++;
            }
        }

        for (int i = 0; i < foodsToSpawn; i++) {

            spawnFood();
        }
    }

    private void checkPowerUpCollision() {

        if (speedPowerUp == null) {
            return;
        }

        if (CollisionService.isColliding(
                player,
                speedPowerUp
        )) {

            SpeedBoostDecorator boost =
                    new SpeedBoostDecorator(player);

            boost.apply();

            speedBoostEndTime =
                    System.currentTimeMillis()
                    + 5000;

            speedPowerUp = null;
        }
    }

    private void updatePowerUps() {

        if (speedBoostEndTime == 0) {
            return;
        }

        if (System.currentTimeMillis()
                >= speedBoostEndTime) {

            player.setSpeedMultiplier(1.0);

            speedBoostEndTime = 0;

            spawnSpeedPowerUp();
        }
    }

    private void spawnFood() {

        double x = Math.random() * WIDTH;

        double y = Math.random() * HEIGHT;

        foods.add(
                new Food(x, y)
        );
    }

    private void spawnSpeedPowerUp() {

        speedPowerUp =
                new PowerUp(
                        Math.random() * WIDTH,
                        Math.random() * HEIGHT
                );
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        for (Food food : foods) {

            food.draw(g);
        }

        if (speedPowerUp != null) {

            speedPowerUp.draw(g);
        }

        g.setColor(Color.WHITE);

        g.drawString(
                "Score: " + score,
                20,
                20
        );

        g.drawString(
                "Speed x"
                        + player.getSpeedMultiplier(),
                20,
                40
        );
    }
}