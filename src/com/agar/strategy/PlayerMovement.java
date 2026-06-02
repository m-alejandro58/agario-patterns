package com.agar.strategy;

import com.agar.entities.Cell;
import com.agar.input.MouseHandler;

/*
 * Hace que la célula siga al mouse.
 */
public class PlayerMovement implements MovementStrategy {

    @Override
    public void move(Cell cell) {

        double targetX =
                MouseHandler.getMouseX();

        double targetY =
                MouseHandler.getMouseY();

        double dx =
                targetX - cell.getX();

        double dy =
                targetY - cell.getY();

        double distance =
                Math.sqrt(dx * dx + dy * dy);

        if (distance > 1) {

            cell.setX(
                    cell.getX()
                            + (dx / distance)
                            * cell.getSpeed()
            );

            cell.setY(
                    cell.getY()
                            + (dy / distance)
                            * cell.getSpeed()
            );
        }
    }
}