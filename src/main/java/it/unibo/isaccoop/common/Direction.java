package it.unibo.isaccoop.common;

import java.util.Random;

public enum Direction{
    UP(0,-1), DOWN(0,1), RIGHT(1,0), LEFT(-1,0);

    int x;
    int y;
    Direction(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public static Direction getRandomDir() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
}
