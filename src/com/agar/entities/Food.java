package com.agar.entities;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Representa la comida que el jugador puede consumir.
 *
 * Hereda de Entity.
 */
public class Food extends Entity {

    /*
     * Constructor.
     *
     * La comida aparece en una posición específica.
     *
     * El radio será siempre 5.
     */
    public Food(double x, double y) {

        // Llama al constructor de Entity
        super(x, y, 5);
    }

    /*
     * La comida no se mueve.
     *
     * Por eso no hacemos nada aquí.
     */
    @Override
    public void update() {

    }

    /*
     * Dibuja la comida en pantalla.
     */
    @Override
    public void draw(Graphics g) {

        // Color verde
        g.setColor(Color.GREEN);

        // Dibuja un círculo
        g.fillOval(
                (int) x,
                (int) y,
                radius * 2,
                radius * 2
        );
    }
}