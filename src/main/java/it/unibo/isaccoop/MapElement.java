package it.unibo.isaccoop;

/**
 * Interface to model elements 
 */
public interface MapElement {

    /**
     * @return the ID of a map element
     */
    public int getID();

    /**
     * @return the horizontal dimension of a map element
     */
    public int getWidth();

    /**
     * @return the vertical dimension of a map element
     */
    public int getHeight();

    /**
     * @return the coordinate of a map element
     */
    public Pair<Integer, Integer> getCoord();
}
