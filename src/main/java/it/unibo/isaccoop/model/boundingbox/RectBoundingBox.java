package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;

/**
 * Implements the BoundingBox interface.
 */
public class RectBoundingBox implements BoundingBox {

    private final Point2D p0;
    private final Point2D p1;

    /**
     * Constractor for rectangular BoundingBox.
     * 
     * @param p0
     * @param p1
     */
    public RectBoundingBox(final Point2D p0, final Point2D p1) {
        this.p0 = p0;
        this.p1 = p1;
    }

    /**
     * 
     * @return p0 (upper left point)
     */
    public Point2D getULCorner() {
        return p0;
    }

    /**
     * 
     * @return p1 (bottom right point)
     */
    public Point2D getBRCorner() {
        return p1;
    }

    /**
     * Check for collisions.
     * 
     * @param p2
     * @param p3
     * @return true if a collision occurs
     */
    @Override
    public boolean isCollidingWith(final Point2D p2, final Point2D p3) {
        return  p0.getX() <= p2.getX() + p3.getX() 
                && p0.getX() + p1.getX() >= p2.getX()
                && p0.getY() <= p2.getY() + p3.getY()
                && p0.getY() + p1.getY() >= p2.getY();
    }

}
