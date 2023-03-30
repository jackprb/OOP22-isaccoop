package it.unibo.isaccoop.model.common;

import it.unibo.isaccoop.graphics.Graphics;
import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.model.boundingbox.BoundingBox;
import it.unibo.isaccoop.model.boundingbox.CircleBoundingBox;

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
    public void updateGraphics(Graphics g) {
        graphicComponent.update(this, g);
    }
}
