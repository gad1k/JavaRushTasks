package com.javarush.games.racer;

import com.javarush.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {
    public int speed = 1;

    private static int playerCarHeight = ShapeMatrix.PLAYER.length;
    private Direction direction;

    public PlayerCar() {
        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void move() {
        if (direction == null)
            direction = Direction.NONE;
        switch (direction) {
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
        if (x < RoadManager.LEFT_BORDER)
            x = RoadManager.LEFT_BORDER;
        if (x > RoadManager.RIGHT_BORDER - width)
            x = RoadManager.RIGHT_BORDER - width;
    }

    public void stop() {
        matrix = ShapeMatrix.PLAYER_DEAD;
    }
}