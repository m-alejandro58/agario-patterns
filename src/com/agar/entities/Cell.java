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

    /*
     * State controla esta velocidad.
     */
    private double baseSpeed;

    /*
     * Decorator modificará este multiplicador.
     */
    private double speedMultiplier;

    private MovementStrategy movementStrategy;

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
        this.color = color;

        this.baseSpeed = speed;
        this.speedMultiplier = 1.0;

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

    /*
     * Velocidad real usada por Strategy.
     */
    public double getSpeed() {

        return baseSpeed * speedMultiplier;
    }

    /*
     * State modifica esto.
     */
    public void setBaseSpeed(double baseSpeed) {

        this.baseSpeed = baseSpeed;
    }

    public double getBaseSpeed() {

        return baseSpeed;
    }

    /*
     * Decorator modifica esto.
     */
    public void setSpeedMultiplier(
            double speedMultiplier
    ) {

        this.speedMultiplier = speedMultiplier;
    }

    public double getSpeedMultiplier() {

        return speedMultiplier;
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