package com.agar.decorator;

import com.agar.entities.Cell;

/*
 * Duplica temporalmente la velocidad.
 */
public class SpeedBoostDecorator extends CellDecorator {

    public SpeedBoostDecorator(Cell cell) {

        super(cell);
    }

    @Override
    public void apply() {

        cell.setSpeedMultiplier(2.0);
    }

    @Override
    public void remove() {

        cell.setSpeedMultiplier(1.0);
    }
}