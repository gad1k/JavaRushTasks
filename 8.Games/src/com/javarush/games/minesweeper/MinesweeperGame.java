package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 20;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private int score;
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;

    private boolean isGameStopped;

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    private void createGame() {
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++) {
                if (getRandomNumber(10) == 0) {
                    countMinesOnField++;
                    gameField[y][x] = new GameObject(x, y, true);
                } else
                    gameField[y][x] = new GameObject(x, y, false);
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private void restart() {
        isGameStopped = false;
        countMinesOnField = 0;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        createGame();
    }

    private void countMineNeighbors() {
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++)
                if (!gameField[y][x].isMine) {
                    for (GameObject neighbor : getNeighbors(gameField[y][x]))
                        if (neighbor.isMine)
                            gameField[y][x].countMineNeighbors++;
                }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> neighbors = new ArrayList<GameObject>();
        for (int x = gameObject.x - 1; x <= (Math.min(gameObject.x + 1, SIDE - 1)); x++)
            for (int y = gameObject.y - 1; y <= (Math.min(gameObject.y + 1, SIDE - 1)); y++) {
                if (x < 0 || y < 0 || (x == gameObject.x && y == gameObject.y))
                    continue;
                else
                    neighbors.add(gameField[y][x]);
            }
        return neighbors;
    }

    private void openTile(int x, int y) {
        if (!gameField[y][x].isOpen && !gameField[y][x].isFlag && !isGameStopped) {
            gameField[y][x].isOpen = true;
            countClosedTiles--;
            setCellColor(x, y, Color.GREEN);
            if (gameField[y][x].isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
            else {
                score += 5;
                setScore(score);
                if (gameField[y][x].countMineNeighbors != 0)
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                else {
                    setCellValue(x, y, "");
                    for (GameObject neighbor : getNeighbors(gameField[y][x]))
                        openTile(neighbor.x, neighbor.y);
                }
            }
        }
        if (countClosedTiles == countMinesOnField && !gameField[y][x].isMine)
            win();
    }

    private void markTile(int x, int y) {
        if (!gameField[y][x].isOpen && countFlags != 0)
            if (!gameField[y][x].isFlag) {
                gameField[y][x].isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.DARKCYAN);
            } else {
                gameField[y][x].isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }
        if (!gameField[y][x].isOpen && gameField[y][x].isFlag && countFlags == 0) {
            gameField[y][x].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Game is over!", Color.BLACK, 24);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTPINK, "Congratulation, You are win!", Color.BLACK, 24);
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped)
            restart();
        else
            openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}