package com.agar.facade;

import java.util.Iterator;
import java.util.List;

import com.agar.decorator.SpeedBoostDecorator;
import com.agar.entities.Cell;
import com.agar.entities.Food;
import com.agar.entities.PowerUp;
import com.agar.services.CollisionService;

/*
 * Facade Pattern
 *
 * Centraliza la lógica principal del juego.
 */
public class GameFacade {

    private Cell player;

    private List<Food> foods;

    private PowerUp speedPowerUp;

    private int score;

    private long speedBoostEndTime;

    public GameFacade(
            Cell player,
            List<Food> foods,
            PowerUp speedPowerUp
    ) {

        this.player = player;
        this.foods = foods;
        this.speedPowerUp = speedPowerUp;

        this.score = 0;
        this.speedBoostEndTime = 0;
    }

    public void update() {

        player.update();

        checkFoodCollisions();

        checkPowerUpCollision();

        updatePowerUps();
    }

    private void checkFoodCollisions() {

        int foodsToSpawn = 0;

        Iterator<Food> iterator =
                foods.iterator();

        while (iterator.hasNext()) {

            Food food = iterator.next();

            if (CollisionService.isColliding(
                    player,
                    food
            )) {

                iterator.remove();

                player.grow(1);

                score++;

                foodsToSpawn++;
            }
        }

        for (int i = 0; i < foodsToSpawn; i++) {

            spawnFood();
        }
    }

    private void checkPowerUpCollision() {

        if (speedPowerUp == null) {
            return;
        }

        if (CollisionService.isColliding(
                player,
                speedPowerUp
        )) {

            SpeedBoostDecorator boost =
                    new SpeedBoostDecorator(player);

            boost.apply();

            speedBoostEndTime =
                    System.currentTimeMillis()
                    + 5000;

            speedPowerUp = null;
        }
    }

    private void updatePowerUps() {

        if (speedBoostEndTime == 0) {
            return;
        }

        if (System.currentTimeMillis()
                >= speedBoostEndTime) {

            player.setSpeedMultiplier(1.0);

            speedBoostEndTime = 0;

            spawnSpeedPowerUp();
        }
    }

    private void spawnFood() {

        foods.add(
                new Food(
                        Math.random() * 1200,
                        Math.random() * 800
                )
        );
    }

    private void spawnSpeedPowerUp() {

        speedPowerUp =
                new PowerUp(
                        Math.random() * 1200,
                        Math.random() * 800
                );
    }

    public int getScore() {

        return score;
    }

    public PowerUp getSpeedPowerUp() {

        return speedPowerUp;
    }
}