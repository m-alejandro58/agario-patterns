package com.agar.strategy;

import com.agar.entities.Cell;

/*
 * Strategy Pattern
 *
 * Define cómo se moverá una célula.
 */
public interface MovementStrategy {

    void move(Cell cell);

}