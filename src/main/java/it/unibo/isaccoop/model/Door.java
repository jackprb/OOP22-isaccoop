package it.unibo.isaccoop.model;

import it.unibo.isaccoop.common.MapElement;

/**
 *  Interface that models the concept of a door, needed to move from a room to another.
 */
public interface Door extends MapElement {

    /**
     * @return the room accessible using this door
     */
    Room getCorrespondingRoom();
}
