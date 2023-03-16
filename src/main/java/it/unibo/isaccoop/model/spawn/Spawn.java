package it.unibo.isaccoop.model.spawn;

import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;

/**
 * 
 */
public interface Spawn {

    /**
     * Method that set the position of the elements inside the room.
     * @param elementsToSpawn
     */
    void setPosition(List<MapElement> elementsToSpawn);
}
