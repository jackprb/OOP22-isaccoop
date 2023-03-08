package it.unibo.isaccoop;

import java.util.Objects;

public class MapElementImpl implements MapElement {

    private final int id;
    private final int width;
    private final int height;
    private Pair<Integer, Integer> coord;

    public MapElementImpl(final int id, final int width, final int height, final Pair<Integer, Integer> coord) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.coord = coord;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Pair<Integer, Integer> getCoord() {
        return this.coord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, height, id, width);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MapElementImpl other = (MapElementImpl) obj;
        return Objects.equals(coord, other.coord) && height == other.height && id == other.id && width == other.width;
    }	
}
