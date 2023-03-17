package it.unibo.isaccoop.model.common;

/***/
public abstract class AbstractMapElement implements MapElement {

    private Point2D coords;

    /**
     * Constructor for {@link AbstractMapElement}.
     *
     * @param coords initial coords
     * */
    public AbstractMapElement(final Point2D coords) {
        this.coords = coords;
    }

    /**
     * Constructor for {@link AbstractMapElement} with fixed initial position.
     * */
    public AbstractMapElement() {
        this.coords = new Point2D(0.0, 0.0);
    }

    /***/
    @Override
    public Point2D getCoords() {
        return new Point2D(this.coords.getX(), this.coords.getY());
    }

    /***/
    @Override
    public void setCoords(final Point2D coords) {
        this.coords = new Point2D(coords.getX(), coords.getY());
    }

}
