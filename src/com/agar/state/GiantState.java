package com.agar.state;

import com.agar.entities.Cell;

public class GiantState implements CellState {

    @Override
    public void applyState(Cell cell) {

        cell.setSpeed(2);
    }

    @Override
    public String getStateName() {

        return "GIANT";
    }
}