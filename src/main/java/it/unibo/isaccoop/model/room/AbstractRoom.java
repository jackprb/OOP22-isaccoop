package it.unibo.isaccoop.model.room;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.MapElementImpl;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Abstract {@link Room} that implements the main methods.
 */
public abstract class AbstractRoom extends MapElementImpl implements Room {

    private final List<Door> doors = new LinkedList<>();
    private final RoomType roomType;

    /**
     * 
     * @param id id of this room
     * @param width horizontal dimension of this room
     * @param height vertical dimension of this room
     * @param coord coordinates of this room inside the level
     * @param roomType type of this room
     */
    public AbstractRoom(final int id, final int width, final int height, 
            final Pair<Integer, Integer> coord, final RoomType roomType) {
        super(id, width, height, coord);
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
