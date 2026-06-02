package com.agar.builder;

import java.awt.Color;

import com.agar.entities.Cell;

/*
 * Builder encargado de construir objetos Cell
 * paso a paso.
 */
public class CellBuilder {

    private String name;
    private double x;
    private double y;
    private int radius;
    private double speed;
    private Color color;

    public CellBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CellBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public CellBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public CellBuilder setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public CellBuilder setSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    public CellBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    /*
     * Construye el objeto Cell final.
     */
    public Cell build() {

        return new Cell(
                name,
                x,
                y,
                radius,
                speed,
                color
        );
    }
}