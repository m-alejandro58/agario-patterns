package com.agar.state;

import com.agar.entities.Cell;

/*
 * State Pattern
 *
 * Define el comportamiento según el estado.
 */
public interface CellState {

    void applyState(Cell cell);

    String getStateName();
}