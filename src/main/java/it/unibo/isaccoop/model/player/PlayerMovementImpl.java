package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;

/**
 * Implement the PlayerMovement interface and
 * model player position directly by extending PlayerStatImpl.
 * */
public class PlayerMovementImpl extends PlayerStatImpl implements PlayerMovement {

    private final Double distance = super.getSpeed();
    private final double x = super.getCoords().getX();
    private final double y = super.getCoords().getY();

    /**
     * @param direction the direction which the player moves
     * */
    @Override
    public void update(final Direction direction) {
        switch (direction) {
            case UP:
                super.setCoords(new Point2D(x, y - distance));
            break;
            case RIGHT:
                super.setCoords(new Point2D(x + distance, y));
            break;
            case DOWN:
                super.setCoords(new Point2D(x, y + distance));
            break;
            case LEFT:
                super.setCoords(new Point2D(x - distance, y));
            break;
            default:
                super.setCoords(new Point2D(x, y));
        }
    }
}
