package it.unibo.isaccoop.model.room;

import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Interface to control a {@link Level}.
 */
public interface LevelController {

    /**
     * Get the current Level.
     * @return the current level
     */
    Level getCurrentLevel();

    /**
     * @return the unmodifiable list of all the rooms in this level
     */
    List<Room> getRoomsOfCurrentLevel();

    /**
     * @return the number of rooms inside this level
     */
    int getNumberOfRooms();

    /**
     * @return the coordinates of the room where the player is 
     */
    Point2D getPlayerRoomCoord();

    /**
     * @return the room where the player is 
     */
    Room getPlayerRoom();

    /**
     * @return the player
     */
    Player getPlayer();

    /**
     * Check if the specified room is "completed", that is, if there are no more
     * enemies to defeat (STANDARD room), or if the boss has been defeated (BOSS room).
     * @param room the room to check
     * @return true if all enemies in STANDARD room or the final boss in BOSS room
     * have been defeated, false otherwise
     */
    boolean isRoomComplete(Room room);

    /**
     * Check if current level is complete.
     * A level is complete if all its room are complete.
     * @return true if current level is complete, false otherwise
     */
    boolean isCurrentLevelComplete();

    /**
     * Check if all levels are complete.
     * A level is complete if all its room are complete.
     * @return true if all levels are complete, false otherwise
     */
    boolean areAllLevelsComplete();

    /**
     * @return a list of coordinates of accessible rooms, 
     * near the room where the player is
     */
    List<Room> getAccessibleRooms();

    /**
     * Move the player to the specified room.
     * @param room the room where the player moves to
     */
    void moveToRoom(Room room);
}
