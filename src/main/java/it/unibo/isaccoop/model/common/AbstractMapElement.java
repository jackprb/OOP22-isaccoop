package it.unibo.isaccoop.model.common;

import org.apache.commons.lang3.tuple.Pair;

/***/
public abstract class AbstractMapElement implements MapElement {

    private Pair<Double, Double> coords;

    /**
     * Constructor for {@link AbstractMapElement}.
     *
     * @param coords initial coords
     * */
    public AbstractMapElement(final Pair<Double, Double> coords) {
        this.coords = coords;
    }

    /***/
    @Override
    public Pair<Double, Double> getCoords() {
        return Pair.of(this.coords.getLeft(), this.coords.getRight());
    }

    /***/
    @Override
    public void setCoords(final Pair<Double, Double> coords) {
        this.coords = Pair.of(coords.getLeft(), coords.getRight());
    }
}
