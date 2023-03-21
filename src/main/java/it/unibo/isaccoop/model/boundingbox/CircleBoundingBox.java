package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/**
 * Implements the BoundingBox interface.
 */
public class CircleBoundingBox implements BoundingBox {

    private final Point2D center;
    private final double radius;

    /**
     * Constractor of the circle bounding box.
     * @param center
     * @param radius
     */
    public CircleBoundingBox(final Point2D center, final double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * 
     * @return radius of the circle bounding box.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Check for collisions of two bounding box.
     * @param p
     * @param radius
     * @return true if collision occurs
     */
    @Override
    public boolean isCollidingWith(final Point2D p, final double radius) {
        return new Vector2D(p, center).module() <= radius + this.radius;
    }
}
