package com.agar.services;

import com.agar.entities.Cell;
import com.agar.entities.Food;

/*
 * Encargado de verificar colisiones.
 */
public class CollisionService {

    public static boolean isColliding(
            Cell cell,
            Food food
    ) {

        double dx = cell.getX() - food.getX();
        double dy = cell.getY() - food.getY();

        double distance =
                Math.sqrt(dx * dx + dy * dy);

        return distance <
                (cell.getRadius() + food.getRadius());
    }
}