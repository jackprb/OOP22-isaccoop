package it.unibo.isaccoop.model.room;

import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Interface to control a {@link Level}.
 */
public interface LevelController {

    /**
     * @return the unmodifiable list of all the rooms in this level
     */
    List<Room> getRooms();

    /**
     * @return the coordinates of the room where the player is 
     */
    Pair<Integer, Integer> getPlayerRoomCoord();

    /**
     * @return the room where the player is 
     */
    Room getPlayerRoom();

    /**
     * Check if the specified room is "completed", that is, if there are no more
     * enemies to defeat (STANDARD room), or if the boss has been defeated (BOSS room).
     * @param room the room to check
     * @return true if all enemies in STANDARD room or the final boss in BOSS room
     * have been defeated, false otherwise
     */
    boolean isRoomComplete(Room room);

    /**
     * @return the number of rooms inside this level
     */
    int getNumberOfRooms();

    /**
     * @return a list of coordinates of accessible rooms, 
     * near the room where the player is
     */
    List<Pair<Integer, Integer>> getAccessibleRooms();

    /**
     * Move the player to the specified room.
     * @param room the room where the player moves to
     */
    void moveToRoom(Room room);
}
