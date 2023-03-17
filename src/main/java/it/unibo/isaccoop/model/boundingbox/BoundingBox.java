package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;
/**
 * Iterface that model the bounding box.
 * 
 */
public interface BoundingBox {

    /**
     * Check for collisions.
     * 
     * @param p2
     * @param p3
     * @return true if a collision occurs
     */
    boolean isCollidingWith(Point2D p2, Point2D p3);

}
