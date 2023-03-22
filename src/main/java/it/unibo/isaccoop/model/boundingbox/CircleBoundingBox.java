package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/**
 * Implements the BoundingBox interface.
 */
public class CircleBoundingBox implements BoundingBox {

    private final double radius;

    /**
     * Constractor of the circle bounding box.
     * @param radius
     */
    public CircleBoundingBox(final double radius) {
        this.radius = radius;
    }

    /**
     * 
     * @return radius of the circle bounding box.
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Check for collisions of two bounding box.
     * @param center of first bounding box
     * @param center1 of the second bounding box
     * @param radius of the second bounding box
     * @return true if a collision occours
     */
    @Override
    public boolean isCollidingWith(final Point2D center, final Point2D center1, final double radius) {
        return new Vector2D(center, center1).module() <= radius + this.radius;
    }
}
