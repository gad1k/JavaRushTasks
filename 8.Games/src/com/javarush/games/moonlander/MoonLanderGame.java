package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private Rocket rocket;
    private GameObject landscape;
    private GameObject platform;

    private int score;

    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean isGameStopped;

    private void createGame() {
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        isGameStopped = false;
        score = 1000;
        setTurnTimer(50);
        createGameObjects();
        drawScene();
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++)
            for (int y = 0; y < HEIGHT; y++)
                setCellColor(x, y, Color.BLACK);
        rocket.draw(this);
        landscape.draw(this);
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH / 2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
    }

    private void check() {
        if (rocket.isCollision(landscape) && !(rocket.isCollision(platform) && rocket.isStopped()))
            gameOver();
        if (rocket.isCollision(platform) && rocket.isStopped())
            win();
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Congratulation, You are win!", Color.BLACK, 24);
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        score = 0;
        showMessageDialog(Color.LIGHTPINK, "Game is over!", Color.BLACK, 24);
        stopTurnTimer();
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        if (score > 0)
            score--;
        setScore(score);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
        switch(key) {
            case UP:
                isUpPressed = true;
                break;
            case LEFT:
                isLeftPressed = true;
                isRightPressed = false;
                break;
            case RIGHT:
                isLeftPressed = false;
                isRightPressed = true;
                break;
            case SPACE:
                if (isGameStopped)
                    createGame();
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch(key) {
            case UP:
                isUpPressed = false;
                break;
            case LEFT:
                isLeftPressed = false;
                break;
            case RIGHT:
                isRightPressed = false;
                break;
        }
    }
}