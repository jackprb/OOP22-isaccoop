package it.unibo.isaccoop.common;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Interface to model elements. 
 */
public interface MapElement {

    /**
     * @return the ID of a map element
     */
    int getID();

    /**
     * @return the horizontal dimension of a map element
     */
    int getWidth();

    /**
     * @return the vertical dimension of a map element
     */
    int getHeight();

    /**
     * @return the coordinate of a map element
     */
    Pair<Integer, Integer> getCoord();
}
