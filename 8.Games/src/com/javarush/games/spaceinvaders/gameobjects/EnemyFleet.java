package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int x = 0; x < COLUMNS_COUNT; x++)
            for (int y = 0; y < ROWS_COUNT; y++)
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    private double getLeftBorder() {
        double minLeftBorder = Double.MAX_VALUE;
        for (EnemyShip enemyShip : ships)
            if (enemyShip.x < minLeftBorder)
                minLeftBorder = enemyShip.x;
        return minLeftBorder;
    }

    private double getRightBorder() {
        double maxRightBorder = Double.MIN_VALUE;
        for (EnemyShip enemyShip : ships)
            if (enemyShip.x + enemyShip.width > maxRightBorder)
                maxRightBorder = enemyShip.x + enemyShip.width;
        return maxRightBorder;

    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public void draw(Game game) {
        for (EnemyShip enemyShip : ships)
            enemyShip.draw(game);
    }

    public void move() {
        if (ships.size() == 0)
            return;
        double speed = getSpeed();
        boolean isChanged = false;
        switch (direction) {
            case LEFT:
                if (getLeftBorder() < 0) {
                    direction = Direction.RIGHT;
                    isChanged = true;
                    for (EnemyShip enemyShip : ships)
                        enemyShip.move(Direction.DOWN, speed);
                }
                break;
            case RIGHT:
                if (getRightBorder() > SpaceInvadersGame.WIDTH) {
                    direction = Direction.LEFT;
                    isChanged = true;
                    for (EnemyShip enemyShip : ships)
                        enemyShip.move(Direction.DOWN, speed);
                }
                break;
        }
        if (!isChanged)
            for (EnemyShip enemyShip : ships)
                enemyShip.move(direction, speed);
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0)
            return null;
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0)
            return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public void deleteHiddenShips() {
        Iterator<EnemyShip> iterator = ships.iterator();
        while (iterator.hasNext()) 
            if (!iterator.next().isVisible())
                iterator.remove();
    }

    public double getBottomBorder() {
        Double maxHeight = Double.MIN_VALUE;
        for (EnemyShip ship : ships)
            if (ship.y + ship.height > maxHeight)
                maxHeight = ship.y + ship.height;
        return maxHeight;
    }

    public int getShipsCount() {
        return ships.size();
    }

    public int verifyHit(List<Bullet> bullets) {
        int sum = 0;
        if (bullets.size() == 0)
            return 0;
        for (EnemyShip ship : ships)
            for (Bullet bullet : bullets)
                if (ship.isCollision(bullet) && ship.isAlive && bullet.isAlive) {
                    ship.kill();
                    bullet.kill();
                    sum += ship.score;
                }
        return sum;
    }
}