package it.unibo.isaccoop.model.room;

import java.util.List;

/**
 * Interface to model a level, which contains many {@link Room}.
 */
public interface Level {

    /**
     * Inserts the specified rooms in this level.
     * @param roomList the room list to be added to this level
     * @throws IllegalStateException if this method is called and the level has already a room list
     * @throws IllegalArgumentException if the number of rooms in roomList < 5
     */
    void putRooms(List<Room> roomList);

    /**
     * Get an unmodifiable copy of the list of all rooms in this level.
     * @return an unmodifiable copy of the list containing all the rooms in this level
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
