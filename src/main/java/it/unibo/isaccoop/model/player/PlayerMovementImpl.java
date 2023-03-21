package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.model.common.Point2D;

/**
 * Implement the PlayerMovement interface and
 * model player position directly by extending PlayerStatImpl.
 * */
public class PlayerMovementImpl extends PlayerStatImpl implements PlayerMovement {

    private final float distance = super.getSpeed();
    private final double x = super.getCoords().getX();
    private final double y = super.getCoords().getY();

    /**
     * Move the player to right.
     * */
    @Override
    public void right() {
        super.setCoords(new Point2D(x + distance, y));
    }

    /**
     * Move the player to left.
     * */
    @Override
    public void left() {
        super.setCoords(new Point2D(x - distance, y));
    }

    /**
     * Move the player up.
     * */
    @Override
    public void up() {
        super.setCoords(new Point2D(x, y - distance));
    }

    /**
     * Move the player down.
     * */
    @Override
    public void down() {
        super.setCoords(new Point2D(x, y + distance));
    }

}

