package com.agar.entities;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Representa una comida.
 */
public class Food extends Entity {

    public Food(
            double x,
            double y
    ) {

        super(x, y, 5);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.GREEN);

        g.fillOval(
                (int) (x - radius),
                (int) (y - radius),
                radius * 2,
                radius * 2
        );
    }
}