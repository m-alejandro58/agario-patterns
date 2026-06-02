package com.agar.state;

import com.agar.entities.Cell;

public class NormalState implements CellState {

    @Override
    public void applyState(Cell cell) {

        cell.setSpeed(4);
    }

    @Override
    public String getStateName() {

        return "NORMAL";
    }
}