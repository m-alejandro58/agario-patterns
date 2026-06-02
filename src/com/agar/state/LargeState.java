package com.agar.state;

import com.agar.entities.Cell;

public class LargeState implements CellState {

    @Override
    public void applyState(Cell cell) {

        cell.setSpeed(3);
    }

    @Override
    public String getStateName() {

        return "LARGE";
    }
}