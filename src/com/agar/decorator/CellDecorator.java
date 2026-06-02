package com.agar.decorator;

import com.agar.entities.Cell;

/*
 * Decorator base.
 */
public abstract class CellDecorator {

    protected Cell cell;

    public CellDecorator(Cell cell) {

        this.cell = cell;
    }

    public abstract void apply();

    public abstract void remove();
}