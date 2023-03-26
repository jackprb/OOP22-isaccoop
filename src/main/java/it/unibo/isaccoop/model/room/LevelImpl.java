package it.unibo.isaccoop.model.room;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link Level}.
 */
public final class LevelImpl implements Level {

    private final List<Room> rooms = new LinkedList<>();

    @Override
    public void putRooms(final List<Room> rooms) {
        if (rooms.isEmpty()) {
            throw new IllegalArgumentException("This level must have at least 5 rooms");
        }
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

    @Override
    public boolean isComplete() {
        return this.rooms.stream().allMatch(r -> r.isComplete());
    }

    @Override
    public Room getStartRoom() {
        return this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.START)
                .findFirst().get();
    }
}
