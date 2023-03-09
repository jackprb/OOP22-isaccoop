package it.unibo.isaccoop.common;
import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Implementation of MapElement.
 */
public class MapElementImpl implements MapElement {

    private final int id;
    private final int width;
    private final int height;
    private final Pair<Integer, Integer> coord;

    /**
     * @param id id of the this MapElement
     * @param width horizontal dimension of this MapElement
     * @param height vertical dimension of this MapElement
     * @param coord coordinates of this MapElement
     */
    public MapElementImpl(final int id, final int width, final int height, final Pair<Integer, Integer> coord) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.coord = coord;
    }

    /**
     * return id of this object.
     */
    @Override
    public int getID() {
        return this.id;
    }

    /**
     * return width of this object.
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * return height of this object.
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * return coordinate of this object.
     */
    @Override
    public Pair<Integer, Integer> getCoord() {
        return this.coord;
    }

    /**
     * generate hash of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(coord, height, id, width);
    }

    /**
     * check if two object are the same.
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
        return Objects.equals(coord, other.coord) && height == other.height && id == other.id && width == other.width;
    }
}
