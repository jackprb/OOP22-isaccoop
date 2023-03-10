package it.unibo.isaccoop.model.common;

import java.util.Random;

/**
 * Enum that models the concept of direction.
 */
public enum Direction {
    /**
     * The direction UP.
     */
    UP(0, -1),
    /**
     * The direction DOWN.
     */
    DOWN(0, 1),
    /**
     * The direction RIGHT.
     */
    RIGHT(1, 0),
    /**
     * The direction LEFT.
     */
    LEFT(-1, 0);

    private static final Random RND = new Random();
    private final int x;
    private final int y;
    Direction(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x of this direction
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return the y of this direction
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return a random direction
     */
    public static Direction getRandomDir() {
        return Direction.values()[RND.nextInt(Direction.values().length)];
    }
}
