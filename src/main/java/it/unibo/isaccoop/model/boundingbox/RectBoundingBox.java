package it.unibo.isaccoop.model.boundingbox;

import it.unibo.isaccoop.model.common.Point2D;

/**
 * Implements the BoundingBox interface of a rectangle.
 */
public class RectBoundingBox implements BoundingBox {
    
    private final int width;
    private final int height;

    /**
     * 
     * @param width
     * @param height
     */
    public RectBoundingBox(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Check for collisions of two bounding box.
     * @param center of first bounding box
     * @param center1 of the second bounding box
     * @param circleBox of the second bounding box
     * @return true if a collision occours
     */
    @Override
    public boolean isCollidingWithCricle(final Point2D center, final Point2D center1, final CircleBoundingBox box1) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Check for collisions of a bounding box with the perimeter of a rectangle bounding box.
     * (We suppose that the first bounding box is inside the second one).
     * @param center of first bounding box
     * @param rectangleBox
     * @return true if a collision occours
     */
    @Override
    public boolean isCollidingWithRecPerimeter(final Point2D center, RectBoundingBox rectangleBox) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @return the rectangle width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return the rectangle height
     */
    public int getHeight() {
        return this.height;
    }

}
