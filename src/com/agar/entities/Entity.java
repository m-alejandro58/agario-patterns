package com.agar.entities;

import java.awt.Graphics;

/*
 * Clase base para todas las entidades.
 *
 * x e y representan el CENTRO de la entidad.
 */
public abstract class Entity {

    protected double x;
    protected double y;

    protected int radius;

    public Entity(
            double x,
            double y,
            int radius
    ) {

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}