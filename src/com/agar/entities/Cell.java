package com.agar.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.agar.strategy.MovementStrategy;

import com.agar.state.CellState;
import com.agar.state.NormalState;
import com.agar.state.LargeState;
import com.agar.state.GiantState;

public class Cell extends Entity {

    private String name;
    private Color color;
    private double speed;

    private MovementStrategy movementStrategy;

    /*
     * State Pattern
     */
    private CellState state;

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

        this.state = new NormalState();
    }

    @Override
    public void update() {

        updateState();

        state.applyState(this);

        if (movementStrategy != null) {

            movementStrategy.move(this);
        }
    }

    private void updateState() {

        if (radius >= 80) {

            state = new GiantState();

        } else if (radius >= 40) {

            state = new LargeState();

        } else {

            state = new NormalState();
        }
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(color);

        g.fillOval(
                (int) (x - radius),
                (int) (y - radius),
                radius * 2,
                radius * 2
        );

        g.setColor(Color.WHITE);

        g.drawString(
            name,
            (int) (x - radius),
            (int) (y - radius - 5)
        );

        g.drawString(
            state.getStateName(),
            (int) (x - radius),
            (int) (y - radius - 20)
        );
    }

    public void grow(int amount) {

        radius += amount;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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