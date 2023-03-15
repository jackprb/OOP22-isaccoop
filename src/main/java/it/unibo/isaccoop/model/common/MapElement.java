package it.unibo.isaccoop.model.common;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Interface to model elements.
 */
public interface MapElement {

    /**
     * @return the coordinates of a map element
     */
    Pair<Double, Double> getCoords();

    /**
     *  Set new coords to map element.
     *
     *  @param coords new coords
     * */
    void setCoords(Pair<Double, Double> coords);
}
