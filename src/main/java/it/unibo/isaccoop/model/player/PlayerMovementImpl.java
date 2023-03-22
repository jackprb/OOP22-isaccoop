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
     * @param direction the direction which the player moves
     * */
    @Override
    public void update(final int direction) {
        switch (direction) {
            /* 0 = up */
            case 0:
                super.setCoords(new Point2D(x, y - distance));
            break;
            /* 1 =  right */
            case 1:
                super.setCoords(new Point2D(x + distance, y));
            break;
            /* 2 = down */
            case 2:
                super.setCoords(new Point2D(x, y + distance));
            break;
            /* 3 = left */
            case 3:
                super.setCoords(new Point2D(x - distance, y));
            break;
            default:
                super.setCoords(new Point2D(x, y));
        }
    }
}
