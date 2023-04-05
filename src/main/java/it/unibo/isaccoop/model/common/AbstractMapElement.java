package it.unibo.isaccoop.model.common;

import java.util.Objects;

import it.unibo.isaccoop.graphics.Graphics;
import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.model.boundingbox.BoundingBox;
import it.unibo.isaccoop.model.boundingbox.CircleBoundingBox;
import it.unibo.isaccoop.model.boundingbox.RectBoundingBox;

/***/
public abstract class AbstractMapElement implements MapElement {

    private Point2D coords;
    private BoundingBox box;
    private GraphicsComponent graphicComponent;

    /**
     *
     */
    public enum ElementsRadius {

        /**
         * Deafult radius.
         */
        DEFAULT(0.00),
        /**
         * Standard enemy radius.
         */
        ENEMY(3.00),
        /**
         * Item radius.
         */
        ITEM(1.00),
        /**
         * Player radius.
         */
        PLAYER(3.00),
        /**
         * Boss radius.
         */
        BOSS(5.00),
        /**
         * Bullet radius.
         */
        BULLET(0.5);

        private Double value;

        /**
         * @param value
         * set the value.
         * */
         ElementsRadius(final Double value) {
            this.value = value;
        }

        /**
         * @return the value of enum value.
         * */
        public Double getValue() {
            return this.value;
        }
    }

    /**
     * Constructor for {@link AbstractMapElement}.
     *
     * @param coords initial coords
     * @param elemRadius based on the type of the element
     * */
    public AbstractMapElement(final Point2D coords, final ElementsRadius elemRadius) {
        this.coords = coords;
        this.box = new CircleBoundingBox(elemRadius.getValue());
    }

    /**
     * Constructor for {@link AbstractMapElement} with fixed initial position.
     * @param elemRadius based on the type of the element
     * */
    public AbstractMapElement(final ElementsRadius elemRadius) {
        this.coords = new Point2D(0.0, 0.0);
        this.box = new CircleBoundingBox(elemRadius.getValue());
    }

    /**
     * Constructor for {@link AbstractMapElement} with fixed initial position.
     * @param elemRadius based on the type of the element
     * @param gr
     * */
    public AbstractMapElement(final ElementsRadius elemRadius, final GraphicsComponent gr) {
        this.coords = new Point2D(0.0, 0.0);
        this.box = new CircleBoundingBox(elemRadius.getValue());
        this.graphicComponent = gr;
    }

    /**
     * Constructor for {@link AbstractMapElement} with fixed initial position.
     * @param width
     * @param height
     * @param gr graphics component
     */
    public AbstractMapElement(final int width, final int height, final GraphicsComponent gr) {
        this.coords = new Point2D(0.0, 0.0);
        this.box = new RectBoundingBox(width, height);
        this.graphicComponent = gr;
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

    /***/
    protected void setGraphicsComponents(final GraphicsComponent gr) {
        this.graphicComponent = gr;
    }

    /**
     *
     * @return collision box
     */
    @Override
    public BoundingBox getBox() {
        return this.box;
    }

    /**
     *
     */
    @Override
    public void updateGraphics(final Graphics g) {
        graphicComponent.update(this, g);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coords);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractMapElement other = (AbstractMapElement) obj;
        return Double.compare(coords.getX(), other.coords.getX()) == 0 &&
                Double.compare(coords.getY(), other.coords.getY()) == 0;
    }

}
