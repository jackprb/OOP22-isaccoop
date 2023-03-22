package it.unibo.isaccoop.model.common;
import java.util.Objects;

/**
 * Implementation of {@link MapElement}.
 */
public class MapElementImpl extends AbstractMapElement {

    private final int width;
    private final int height;

    /**
     * @param width horizontal dimension of this MapElement
     * @param height vertical dimension of this MapElement
     * @param coord coordinates of this MapElement
     */
    public MapElementImpl(final int width, final int height, final Point2D coord) {
        super(coord, ElementsRadius.DEFAULT);
        this.width = width;
        this.height = height;
    }

    /**
     * return width of this object.
     *
     * @return map element width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * return height of this object.
     *
     * @return map element height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * generate hash of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.getCoords(), height, width);
    }

    /**
     * check if two objects are the same.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MapElementImpl other = (MapElementImpl) obj;
        return Objects.equals(super.getCoords(), other.getCoords()) && height == other.height && width == other.width;
    }
}
