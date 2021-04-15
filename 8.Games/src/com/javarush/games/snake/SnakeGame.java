package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;

    private int turnDelay;
    private int score;
    private Snake snake;
    private Apple apple;

    private boolean isGameStopped;

    private void createGame() {
        turnDelay = 300;
        score = 0;
        isGameStopped = false;
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        setTurnTimer(turnDelay);
        setScore(score);
        createNewApple();
        drawScene();
    }

    private void createNewApple() {
        do
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        while (snake.checkCollision(apple));
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++)
            for (int y = 0; y < HEIGHT; y++)
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
        snake.draw(this);
        apple.draw(this);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Game is over!", Color.BLACK, 24);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Congratulation, You are win!", Color.BLACK, 24);
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive)
            gameOver();
        if (snake.getLength() > GOAL)
            win();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch(key) {
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
        }
        if (key == Key.SPACE && isGameStopped)
            createGame();
    }
}