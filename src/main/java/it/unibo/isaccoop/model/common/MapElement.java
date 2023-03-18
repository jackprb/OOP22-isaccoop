package it.unibo.isaccoop.model.common;

/**
 * Interface to model elements.
 */
public interface MapElement {

    /**
     * @return the coordinates of a map element
     */
    Point2D getCoords();

    /**
     *  Set new coords to map element.
     *
     *  @param coords new coords
     * */
    void setCoords(Point2D coords);
}
