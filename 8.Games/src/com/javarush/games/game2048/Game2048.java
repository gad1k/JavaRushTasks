package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;

    private int score;
    private int[][] gameField;

    private boolean isGameStopped = false;

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++)
                setCellColoredNumber(x, y, gameField[y][x]);
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048)
            win();
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        int value = getRandomNumber(10);
        while (gameField[x][y] != 0) {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }
        if (value != 9)
            gameField[x][y] = 2;
        else
            gameField[x][y] = 4;
    }

    private int getMaxTileValue() {
        int maxValue = Integer.MIN_VALUE;
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++)
                if (gameField[x][y] > maxValue)
                    maxValue = gameField[x][y];
        return maxValue;
    }

    private boolean compressRow(int[] row) {
        boolean isChanged = false;
        for (int i = 1; i < row.length; i++)
            if (row[i] != 0)
                for (int j = 0; j < i; j++)
                    if (row[j] == 0) {
                        row[j] = row[i];
                        row[i] = 0;
                        isChanged = true;
                        break;
                    }
        return isChanged;
    }

    private boolean mergeRow(int[] row) {
        boolean isChanged = false;
        for (int i = 0; i < row.length; i++) {
            if (i == row.length - 1)
                break;
            if (row[i] == row[i + 1] && row[i] != 0 && row[i + 1] != 0) {
                row[i] *= 2;
                row[i + 1] = 0;
                score += row[i];
                setScore(score);
                i++;
                isChanged = true;
            }
        }
        return isChanged;
    }

    private boolean canUserMove() {
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++)
                if (gameField[x][y] == 0)
                    return true;
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++) {
                if (x == SIDE - 1 && y == SIDE - 1)
                    continue;
                if (x == SIDE - 1 && y != SIDE - 1) {
                    if (gameField[x][y] == gameField[x][y + 1])
                        return true;
                } else if (x != SIDE - 1 && y == SIDE - 1) {
                    if (gameField[x][y] == gameField[x + 1][y])
                        return true;
                } else if (gameField[x][y] == gameField[x][y + 1] || gameField[x][y] == gameField[x + 1][y])
                    return true;
            }
        return false;
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveLeft() {
        boolean isChanged = false;
        for (int x = 0; x < SIDE; x++) {
            if (compressRow(gameField[x]))
                isChanged = true;
            if (mergeRow(gameField[x]))
                isChanged = true;
            if (compressRow(gameField[x]))
                isChanged = true;
        }
        if (isChanged)
            createNewNumber();
    }

    private void rotateClockwise() {
        int[][] copyGameField = new int[SIDE][SIDE];
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++)
                copyGameField[x][y] = gameField[x][y];
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++)
                gameField[y][SIDE - (x + 1)] = copyGameField[x][y];
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), value == 0 ? "" : String.valueOf(value));
    }

    private Color getColorByValue(int value) {
        Color color = Color.WHITE; //2
        switch(value) {
            case 2:
                color = Color.VIOLET;
                break;
            case 4:
                color = Color.SLATEBLUE;
                break;
            case 8:
                color = Color.DODGERBLUE;
                break;
            case 16:
                color = Color.TURQUOISE;
                break;
            case 32:
                color = Color.DARKSEAGREEN;
                break;
            case 64:
                color = Color.LIGHTGREY;
                break;
            case 128:
                color = Color.SPRINGGREEN;
                break;
            case 256:
                color = Color.YELLOWGREEN;
                break;
            case 512:
                color = Color.GOLDENROD;
                break;
            case 1024:
                color = Color.FUCHSIA;
                break;
            case 2048:
                color = Color.ORANGERED;
                break;
        }
        return color;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Congratulation, You are win!", Color.BLACK, 24);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Game is over!", Color.BLACK, 24);
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                score = 0;
                setScore(score);
                createGame();
                drawScene();
            }
        } else {
            if (!canUserMove()) {
                gameOver();
            } else {
                switch (key) {
                    case UP:
                        moveUp();
                        drawScene();
                        break;
                    case RIGHT:
                        moveRight();
                        drawScene();
                        break;
                    case DOWN:
                        moveDown();
                        drawScene();
                        break;
                    case LEFT:
                        moveLeft();
                        drawScene();
                        break;
                }
            }
        }
    }
}