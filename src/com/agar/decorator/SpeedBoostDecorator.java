package com.agar.decorator;

import com.agar.entities.Cell;

/*
 * Aumenta temporalmente la velocidad.
 */
public class SpeedBoostDecorator extends CellDecorator {

    public SpeedBoostDecorator(Cell cell) {

        super(cell);
    }

    @Override
    public void apply() {

        cell.setSpeed(
                cell.getSpeed() * 2
        );
    }
}