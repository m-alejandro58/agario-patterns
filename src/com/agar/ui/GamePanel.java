package com.agar.ui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import com.agar.entities.Cell;
import com.agar.entities.Food;

/*
 * Panel principal del juego.
 *
 * Aquí dibujaremos:
 * - jugador
 * - comida
 * - posteriormente bots
 */
public class GamePanel extends JPanel {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    // Jugador principal
    private Cell player;

    // Lista de comidas
    private List<Food> foods;

    public GamePanel() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        initializeGame();
    }

    /*
     * Inicializa los objetos del juego.
     */
    private void initializeGame() {

        // Crear jugador

        player = new Cell(
                "Jugador",
                500,
                300,
                25,
                4,
                Color.BLUE
        );

        // Crear lista de comida

        foods = new ArrayList<>();

        /*
         * Generar 20 comidas
         */
        for (int i = 0; i < 20; i++) {

            double x = Math.random() * WIDTH;
            double y = Math.random() * HEIGHT;

            foods.add(new Food(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Dibujar jugador
        player.draw(g);

        // Dibujar comida

        for (Food food : foods) {

            food.draw(g);
        }
    }
}