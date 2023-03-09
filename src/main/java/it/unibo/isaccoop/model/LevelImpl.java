package it.unibo.isaccoop.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Implementation of {@link Level}.
 */
public class LevelImpl implements Level {

    private final Map<Pair<Integer, Integer>, Room> roomsMap = new HashMap<>();
    
    @Override
    public void putRoomMap(final Map<Pair<Integer, Integer>, Room> roomsMap) {
        
    }

    @Override
    public Map<Pair<Integer, Integer>, Room> getRooms() {
        return Collections.unmodifiableMap(this.roomsMap);
    }
}
