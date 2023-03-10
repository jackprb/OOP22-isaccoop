package it.unibo.isaccoop.model.room;

import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Interface to model a level, which contains many {@link Room}.
 */
public interface Level {

    /**
     * inserts the specified rooms map in this level.
     * 
     * @param roomsMap the room map to be added to this level
     */
    void putRoomMap(Map<Pair<Integer, Integer>, Room> roomsMap);

    /**
     * @return the map of all rooms in this level and their coordinates in room grid
     */
    Map<Pair<Integer, Integer>, Room> getRooms();
}
