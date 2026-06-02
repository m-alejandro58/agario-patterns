package com.agar.factory;

import java.awt.Color;

import com.agar.builder.CellBuilder;
import com.agar.entities.Cell;
import com.agar.strategy.PlayerMovement;

/*
 * Factory Method para crear jugadores.
 *
 * Utiliza Builder para construir la célula.
 */
public class PlayerFactory implements EntityFactory<Cell> {

    @Override
    public Cell create() {

        return new CellBuilder()
                .setName("Jugador")
                .setX(500)
                .setY(300)
                .setRadius(25)
                .setSpeed(4)
                .setColor(Color.BLUE)
                .setMovementStrategy(
                        new PlayerMovement()
                )
                .build();
    }
}