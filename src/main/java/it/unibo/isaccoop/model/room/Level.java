package it.unibo.isaccoop.model.room;

import java.util.List;

import it.unibo.isaccoop.model.player.Player;

/**
 * Interface to model a level, which contains many {@link Room}.
 * A level can be figured as a 2D grid; each room has its coordinate (i, j), that is, the indices of the
 * {@link Room} itself as an element of the grid.
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
     * A level is complete if all its room are complete.
     * @return true if this level is complete, false otherwise
     */
    boolean isLevelComplete();

    /**
     * Get the room where the player begins.
     * @return the room where the player begins
     */
    Room getStartRoom();

    /**
     * Get the room where the player currently is.
     * @return the room where the player currently is
     */
    Room getCurrentRoom();

    /**
     * Get the player.
     * @return the player
     */
    Player getPlayer();

    /**
     * Check if the current room is "completed", that is, if there are no more
     * enemies to defeat (STANDARD room), or if the boss has been defeated (BOSS room).
     * @return always true for NON-STANDARD and NON-BOSS rooms, <br>true if all enemies in STANDARD room 
     * or the final boss in BOSS room have been defeated, <br>false otherwise
     */
    boolean isCurrentRoomComplete();
}
