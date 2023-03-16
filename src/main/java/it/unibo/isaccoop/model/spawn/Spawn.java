package it.unibo.isaccoop.model.spawn;

import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;

/**
 * 
 * @param <E>
 */
public interface Spawn {

    /**
     * Method that set the position of the element inside the room.
     * @param elementToSpawn
     */
    void setPosition(List<MapElement> elementsToSpawn);
}
