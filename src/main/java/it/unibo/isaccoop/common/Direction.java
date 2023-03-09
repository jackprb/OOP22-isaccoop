package it.unibo.isaccoop.common;

import java.util.Random;

/**
 * Enum that models the concept of direction.
 */
public enum Direction {
    UP(0,-1), DOWN(0,1), RIGHT(1,0), LEFT(-1,0);

    final int x;
    final int y;
    Direction(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return a random direction
     */
    public static Direction getRandomDir() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
}
