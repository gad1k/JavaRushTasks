package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

import com.javarush.engine.cell.*;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;

    private List<GameObject> snakeParts = new ArrayList<GameObject>();

    public Snake(int x, int y) {
        for (int i = x; i < x + 3; i++)
            snakeParts.add(new GameObject(i, y));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (i == 0)
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN,
                        isAlive ? Color.BLACK : Color.RED, 75);
            else
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN,
                        isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public void move(Apple apple) {
        GameObject snakeHead = createNewHead();
        if (snakeHead.x < 0 || snakeHead.x >= SnakeGame.WIDTH || snakeHead.y < 0 || snakeHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        }
        if (checkCollision(snakeHead)) {
            isAlive = false;
            return;
        }
        snakeParts.add(0, snakeHead);
        if (snakeHead.x == apple.x && snakeHead.y == apple.y)
            apple.isAlive = false;
        else
            removeTail();
    }

    public GameObject createNewHead() {
        GameObject snakeHead = null;
        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;
        switch (direction) {
            case UP:
                snakeHead = new GameObject(headX, headY - 1);
                break;
            case RIGHT:
                snakeHead = new GameObject(headX + 1, headY);
                break;
            case DOWN:
                snakeHead = new GameObject(headX, headY + 1);
                break;
            case LEFT:
                snakeHead = new GameObject(headX - 1, headY);
                break;
        }
        return snakeHead;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public void setDirection(Direction direction) {
        if (this.direction == Direction.UP && direction == Direction.DOWN)
            return;
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT)
            return;
        if (this.direction == Direction.DOWN && direction == Direction.UP)
            return;
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT)
            return;
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) &&
                snakeParts.get(0).x == snakeParts.get(1).x)
            return;
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) &&
                snakeParts.get(0).y == snakeParts.get(1).y)
            return;
        this.direction = direction;
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject snakePart : snakeParts) {
            if (snakePart.x == gameObject.x && snakePart.y == gameObject.y)
                return true;
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }
}