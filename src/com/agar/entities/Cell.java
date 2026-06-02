package com.agar.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.agar.strategy.MovementStrategy;

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

    private String name;
    private Color color;
    private double speed;

    /*
     * Strategy Pattern
     *
     * Define cómo se moverá la célula.
     */
    private MovementStrategy movementStrategy;

    public Cell(
            String name,
            double x,
            double y,
            int radius,
            double speed,
            Color color,
            MovementStrategy movementStrategy
    ) {

        super(x, y, radius);

        this.name = name;
        this.speed = speed;
        this.color = color;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public void update() {

        if (movementStrategy != null) {
            movementStrategy.move(this);
        }
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(color);

        g.fillOval(
                (int) x,
                (int) y,
                radius * 2,
                radius * 2
        );

        g.setColor(Color.WHITE);

        g.drawString(
                name,
                (int) x,
                (int) y - 5
        );
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(
            MovementStrategy movementStrategy
    ) {
        this.movementStrategy = movementStrategy;
    }
}