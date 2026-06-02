package com.agar.strategy;

import com.agar.entities.Cell;

/*
 * Strategy para bots.
 * Se mueven en una dirección aleatoria.
 */
public class RandomMovement implements MovementStrategy {

    private double directionX;
    private double directionY;

    private long nextDirectionChange;

    public RandomMovement() {

        generateNewDirection();
    }

    @Override
    public void move(Cell cell) {

        if (System.currentTimeMillis()
                >= nextDirectionChange) {

            generateNewDirection();
        }

        cell.setX(
                cell.getX()
                        + directionX
                        * cell.getSpeed()
        );

        cell.setY(
                cell.getY()
                        + directionY
                        * cell.getSpeed()
        );

        // Mantener dentro de la ventana

        if (cell.getX() < 0) {

            directionX *= -1;
        }

        if (cell.getX() > 1200) {

            directionX *= -1;
        }

        if (cell.getY() < 0) {

            directionY *= -1;
        }

        if (cell.getY() > 800) {

            directionY *= -1;
        }
    }

    private void generateNewDirection() {

        double angle =
                Math.random() * Math.PI * 2;

        directionX = Math.cos(angle);

        directionY = Math.sin(angle);

        nextDirectionChange =
                System.currentTimeMillis()
                + 2000;
    }
}