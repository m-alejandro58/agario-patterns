package com.agar.factory;

import java.awt.Color;

import com.agar.builder.CellBuilder;
import com.agar.entities.Cell;
import com.agar.strategy.RandomMovement;

/*
 * Factory Method para bots.
 */
public class BotFactory {

    public Cell create() {

        return new CellBuilder()
                .setName("BOT")
                .setX(Math.random() * 1200)
                .setY(Math.random() * 800)
                .setRadius(15)
                .setSpeed(2)
                .setColor(Color.RED)
                .setMovementStrategy(
                        new RandomMovement()
                )
                .build();
    }
}