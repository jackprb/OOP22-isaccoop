package it.unibo.isaccoop.model.player;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Implement the PlayerMovement interface and
 * model player position directly by extending PlayerStatImpl.
 * */
public class PlayerMovementImpl extends PlayerStatImpl implements PlayerMovement {

    private final float distance = super.getSpeed();
    private final double x = super.getCoords().getKey();
    private final double y = super.getCoords().getValue();

    /**
     * Move the player to right.
     * */
    @Override
    public void right() {
        super.setCoords(Pair.of(x + distance, y));
    }

    /**
     * Move the player to left.
     * */
    @Override
    public void left() {
        super.setCoords(Pair.of(x - distance, y));
    }

    /**
     * Move the player up.
     * */
    @Override
    public void up() {
        super.setCoords(Pair.of(x, y - distance));
    }

    /**
     * Move the player down.
     * */
    @Override
    public void down() {
        super.setCoords(Pair.of(x, y + distance));
    }

}

