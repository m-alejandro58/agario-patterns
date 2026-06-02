package com.agar.entities;

// Necesario para dibujar en pantalla
import java.awt.Graphics;

/*
 * Clase abstracta que representa cualquier objeto del juego.
 *
 * Tanto Cell como Food heredarán de esta clase.
 *
 * Aquí definimos los atributos comunes:
 * - posición X
 * - posición Y
 * - radio (tamaño)
 */
public abstract class Entity {

    // Posición horizontal
    protected double x;

    // Posición vertical
    protected double y;

    // Tamaño de la entidad
    protected int radius;

    /*
     * Constructor base.
     *
     * Todas las entidades tendrán:
     * posición X
     * posición Y
     * radio
     */
    public Entity(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /*
     * Cada entidad definirá cómo se actualiza.
     *
     * Ejemplo:
     * - una célula puede moverse
     * - una comida puede no hacer nada
     */
    public abstract void update();

    /*
     * Cada entidad definirá cómo se dibuja.
     */
    public abstract void draw(Graphics g);

    // Getters

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    // Setters

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}