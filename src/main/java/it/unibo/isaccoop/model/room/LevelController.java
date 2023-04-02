package it.unibo.isaccoop.model.room;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Interface to control a list of {@link Level}s.
 * It allows to control and get information about the levels themselves.
 */
public interface LevelController {

    /**
     * Get the current level.
     * @return the current level
     */
    Level getCurrentLevel();

    /**
     * Get the index of current level among the other levels.
     * @return the index of current level among the others
     */
    int getCurrentLevelIndex();

    /**
     * Get the number of levels managed by this LevelController.
     * @return the number of levels managed by this LevelController
     */
    int getNumberOfLevels();

    /**
     * Get an unmodifiable list of all rooms in current level.
     * @return an unmodifiable list of all rooms in current level
     */
    List<Room> getRoomsOfCurrentLevel();

    /**
     * Get the number of rooms inside current level.
     * @return the number of rooms in current level
     */
    int getNumberOfRoomsOfCurrentLevel();

    /**
     * Get the coordinates of the room where the player is 
     * (i.e.: the coordinate of the room inside current level).
     * @return the coordinates of the room where the player is 
     */
    Point2D getCurrentRoomCoord();

    /**
     * Get the room where the player is.
     * @return the room where the player is 
     */
    Room getCurrentRoom();

    /**
     * Get the player.
     * @return the player
     */
    Player getPlayer();

    /**
     * Check if the specified room is "completed", that is, if there are no more
     * enemies to defeat (STANDARD room), or if the boss has been defeated (BOSS room).
     * @param room the room to check
     * @return true for NON-STANDARD and NON-BOSS rooms or if all enemies in STANDARD room 
     * or the final boss in BOSS room have been defeated, false otherwise
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
     * Return an umodifiable map of rooms where the player can go, associated with the {@link Direction}
     * to reach them. Player can go to a room that is UP, DOWN, LEFT, RIGHT of current room.
     * @return an umodifiable map of accessible rooms, near the room where the player is, and the direction
     * to reach them
     */
    Map<Direction, Room> getAccessibleRooms();
    
    /**
     * Get the previous room.
     * @return the previous room (i.e., the room at the LEFT of the current one), or
     * Optional.empty if there is not a previous room
     */
    Optional<Room> getPreviousRoom();

    /**
     * Get the next room.
     * @return the next room (i.e., the room at the RIGHT of the current one), or
     * Optional.empty if there is not a next room
     */
    Optional<Room> getNextRoom();

    /**
     * Move the player to the specified room.
     * @param room the room where the player moves to
     * @return true if the player can move to the specified room (the current one is complete),
     * false otherwise
     */
    boolean moveToRoom(Room room);
}
