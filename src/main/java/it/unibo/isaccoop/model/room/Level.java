package it.unibo.isaccoop.model.room;

import java.util.List;

/**
 * Interface to model a level, which contains many {@link Room}.
 */
public interface Level {

    /**
     * Inserts the specified rooms in this level.
     * 
     * @param rooms the room list to be added to this level
     */
    void putRooms(List<Room> rooms);

    /**
     * @return the list of all the rooms in this level
     */
    List<Room> getRooms();
}
