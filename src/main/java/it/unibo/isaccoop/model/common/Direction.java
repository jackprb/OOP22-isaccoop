package it.unibo.isaccoop.model.common;

import java.util.Random;

/**
 * Enum that models the concept of direction.
 */
public enum Direction {
    /**
     * The direction UP.
     */
    UP(0.0, -1.0),
    /**
     * The direction DOWN.
     */
    DOWN(0.0, 1.0),
    /**
     * The direction RIGHT.
     */
    RIGHT(1.0, 0.0),
    /**
     * The direction LEFT.
     */
    LEFT(-1.0, 0.0);

    private static final Random RND = new Random();
    private final double x;
    private final double y;
    Direction(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x of this direction
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y of this direction
     */
    public double getY() {
        return this.y;
    }

    /**
     * @return a random direction
     */
    public static Direction getRandomDir() {
        return Direction.values()[RND.nextInt(Direction.values().length)];
    }
}
