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
}
