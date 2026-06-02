package com.agar.entities;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Representa una célula.
 *
 * Puede ser:
 * - jugador
 * - bot
 *
 * Hereda de Entity.
 */
public class Cell extends Entity {

    // Nombre de la célula
    private String name;

    // Color con el que se dibuja
    private Color color;

    // Velocidad de movimiento
    private double speed;

    /*
     * Constructor completo.
     */
    public Cell(
            String name,
            double x,
            double y,
            int radius,
            double speed,
            Color color
    ) {

        // Constructor padre
        super(x, y, radius);

        this.name = name;
        this.speed = speed;
        this.color = color;
    }

    /*
     * Más adelante aquí actualizaremos:
     * - movimiento
     * - colisiones
     * - crecimiento
     */
    @Override
    public void update() {

    }

    /*
     * Dibuja la célula en pantalla.
     */
    @Override
    public void draw(Graphics g) {

        // Color de la célula
        g.setColor(color);

        // Dibujar círculo
        g.fillOval(
                (int) x,
                (int) y,
                radius * 2,
                radius * 2
        );

        // Nombre encima de la célula
        g.setColor(Color.WHITE);

        g.drawString(
                name,
                (int) x,
                (int) y - 5
        );
    }

    // Getters

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }
}