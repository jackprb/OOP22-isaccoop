package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;
/**
 * Iterface that model the bounding box.
 * 
 */
public interface BoundingBox {

    /**
     * Check for collisions of two bounding box.
     * @param center of first bounding box
     * @param center1 of the second bounding box
     * @param radius of the second bounding box
     * @return true if a collision occours
     */
    boolean isCollidingWith(Point2D center, Point2D center1, double radius);

}
