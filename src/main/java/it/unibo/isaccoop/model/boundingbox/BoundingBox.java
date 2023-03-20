package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;
/**
 * Iterface that model the bounding box.
 * 
 */
public interface BoundingBox {

    /**
     * Check for collisions of two bounding box.
     * @param p
     * @param radius
     * @return true if collision occurs
     */
    boolean isCollidingWith(Point2D p, double radius);

}
