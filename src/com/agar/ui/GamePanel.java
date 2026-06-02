package com.agar.ui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import com.agar.entities.Cell;
import com.agar.entities.Food;
import com.agar.entities.PowerUp;

import com.agar.factory.PlayerFactory;
import com.agar.input.MouseHandler;

import com.agar.facade.GameFacade;

import com.agar.factory.BotFactory;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private Thread gameThread;

    private Cell player;

    private List<Cell> bots;

    private List<Food> foods;

    private int score;

    private PowerUp speedPowerUp;

    private GameFacade gameFacade;

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

        BotFactory botFactory =
                new BotFactory();

        bots = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            bots.add(botFactory.create());
        }
        foods = new ArrayList<>();

        score = 0;

        for (int i = 0; i < 20; i++) {

            double x = Math.random() * WIDTH;
            double y = Math.random() * HEIGHT;

            foods.add(new Food(x, y));
        }

        speedPowerUp =
                new PowerUp(
                        Math.random() * WIDTH,
                        Math.random() * HEIGHT
                );

        gameFacade =
                new GameFacade(
                        player,
                        foods,
                        speedPowerUp
                );
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

        gameFacade.update();

        for (Cell bot : bots) {

            bot.update();
        }

        score =
                gameFacade.getScore();

        speedPowerUp =
                gameFacade.getSpeedPowerUp();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        for (Cell bot : bots) {

            bot.draw(g);
        }

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