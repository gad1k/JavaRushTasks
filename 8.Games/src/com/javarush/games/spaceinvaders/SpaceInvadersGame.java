package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpaceInvadersGame extends Game {
    private static final int PLAYER_BULLETS_MAX = 1;

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;

    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private EnemyFleet enemyFleet;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private int score;

    private void createGame() {
        setTurnTimer(40);
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        drawScene();
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        for (Bullet enemyBullet : enemyBullets)
            enemyBullet.draw(this);
        playerShip.draw(this);
        for (Bullet playerBullet : playerBullets)
            playerBullet.draw(this);
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++)
            for (int x = 0; x < WIDTH; x++)
                setCellValueEx(x, y, Color.BLACK, "");
        for (Star star : stars)
            star.draw(this);
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        for (int i = 0; i < 8; i++)
            stars.add(new Star(getRandomNumber(64), getRandomNumber(64)));
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet enemyBullet : enemyBullets)
            enemyBullet.move();
        playerShip.move();
        for (Bullet playerBullet : playerBullets)
            playerBullet.move();
    }

    private void removeDeadBullets() {
        Iterator<Bullet> iterator;
        iterator = enemyBullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            if (!bullet.isAlive || bullet.y >= HEIGHT - 1)
                iterator.remove();
        }
        iterator = playerBullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            if (!bullet.isAlive || bullet.y + bullet.height < 0)
                iterator.remove();
        }
    }

    private void check() {
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        playerShip.verifyHit(enemyBullets);
        removeDeadBullets();
        if (!playerShip.isAlive)
            stopGameWithDelay();
        if (enemyFleet.getBottomBorder() >= playerShip.y)
            playerShip.kill();
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin)
            showMessageDialog(Color.LIGHTPINK, "Game is over!", Color.GREEN, 24);
        else
            showMessageDialog(Color.LIGHTPINK, "Game is over!", Color.RED, 24);
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10)
            stopGame(playerShip.isAlive);
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null)
            enemyBullets.add(bullet);
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped && key == Key.SPACE) {
            createGame();
            return;
        }
        switch (key) {
            case LEFT:
                playerShip.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                playerShip.setDirection(Direction.RIGHT);
                break;
            case SPACE:
                Bullet bullet = playerShip.fire();
                if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX)
                    playerBullets.add(bullet);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT)
            playerShip.setDirection(Direction.UP);
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT)
            playerShip.setDirection(Direction.UP);
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x < 0 || x >= SpaceInvadersGame.WIDTH || y < 0 || y >= SpaceInvadersGame.HEIGHT)
            return;
        super.setCellValueEx(x, y, cellColor, value);
    }
}