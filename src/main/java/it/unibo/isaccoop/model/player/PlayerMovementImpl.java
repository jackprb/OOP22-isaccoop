package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.graphics.GraphicsComponent;
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
     * Constructor.
     * @param gr
     * */
    public PlayerMovementImpl(final GraphicsComponent gr) {
        super(gr);
    }

    /**
     * @param direction the direction which the player moves
     * */
    @Override
    public void update(final Direction direction) {
        super.setCoords(this.getMovePreview(direction));
    }

    /***/
    @Override
    public Point2D getMovePreview(final Direction direction) {
        switch (direction) {
        case UP:
            return new Point2D(x, y - distance);
        case RIGHT:
            return new Point2D(x + distance, y);
        case DOWN:
            return new Point2D(x, y + distance);
        case LEFT:
            return new Point2D(x - distance, y);
        default:
            return new Point2D(x, y);
        }
    }
}
