package com.agar.entities;

import java.awt.Color;
import java.awt.Graphics;

/*
 * PowerUp de velocidad.
 */
public class PowerUp extends Entity {

    public PowerUp(
            double x,
            double y
    ) {

        super(x, y, 8);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.YELLOW);

        g.fillOval(
                (int)(x - radius),
                (int)(y - radius),
                radius * 2,
                radius * 2
        );
    }
}