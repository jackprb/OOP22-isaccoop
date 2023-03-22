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

    /**
     * Check if this level is complete.
     * A level is complete if all rooms in there are complete.
     * @return true if this level is complete, false otherwise
     */
    boolean isComplete();

    /**
     * Get the room where the player begins.
     * @return the room where the player begins
     */
    Room getStartRoom();
}
