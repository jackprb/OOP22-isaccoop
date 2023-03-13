package it.unibo.isaccoop.model.room;

import java.util.List;

/**
 * Interface to model a level, which contains many {@link Room}.
 */
public interface Level {

    /**
     * inserts the specified rooms map in this level.
     * 
     * @param roomsMap the room map to be added to this level
     */
    void putRoomMap(List<Room> rooms);

    /**
     * @return the map of all rooms in this level and their coordinates in room grid
     */
    List<Room> getRooms();
}
