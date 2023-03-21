package it.unibo.isaccoop.model.room;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of {@link Level}.
 */
public final class LevelImpl implements Level {

    private final List<Room> rooms = new LinkedList<>();

    @Override
    public void putRooms(final List<Room> rooms) {
        if (this.rooms.isEmpty()) {
            this.rooms.addAll(rooms);
        } else {
            throw new IllegalStateException("This level already has a room map");
        }
    }

    @Override
    public List<Room> getRooms() {
        return Collections.unmodifiableList(this.rooms);
    }
}
