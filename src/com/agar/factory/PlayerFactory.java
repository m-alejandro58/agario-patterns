package com.agar.factory;

import java.awt.Color;

import com.agar.entities.Cell;

/*
 * Factory Method para crear jugadores.
 */
public class PlayerFactory implements EntityFactory<Cell> {

    @Override
    public Cell create() {

        return new Cell(
                "Jugador",
                500,
                300,
                25,
                4,
                Color.BLUE
        );
    }
}