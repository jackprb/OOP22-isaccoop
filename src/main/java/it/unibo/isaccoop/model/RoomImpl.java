package it.unibo.isaccoop.model;

import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.common.MapElementImpl;

public class RoomImpl extends MapElementImpl implements Room {

    private final List<Door> doors;
    private final RoomType roomType;
    //lista powerup, obstacles, enemy, optional<Boss>
    
    public RoomImpl(final int id, final int width, final int height, 
            final Pair<Integer, Integer> coord, final List<Door> doors, final RoomType roomType) {
        super(id, width, height, coord);
        this.doors = doors;
        this.roomType = roomType;
    }

    @Override
    public List<Door> getDoors() {
        return Collections.unmodifiableList(this.doors);
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }
}
