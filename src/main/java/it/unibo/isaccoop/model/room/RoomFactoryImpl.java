package it.unibo.isaccoop.model.room;

import java.util.List;
import org.apache.commons.lang3.tuple.MutablePair;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link RoomFactory}.
 */
public final class RoomFactoryImpl implements RoomFactory {

    private int id = 0;
    private int width;
    private int height;
    private static final int MIN_MAX_ROOM_DIMENSIONS = 200;

    /**
     * Constructor. No parameters needed.
     */
    public RoomFactoryImpl() {
        this.width = MIN_MAX_ROOM_DIMENSIONS;
        this.height = MIN_MAX_ROOM_DIMENSIONS;
    }

    @Override
    public Room buildStartRoom(final MutablePair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.START)
                .putCoord(coordInsideLevel)
                .putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildStandardRoom(final MutablePair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.STANDARD)
                .putCoord(coordInsideLevel)
                .putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildShopRoom(final MutablePair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.SHOP)
                .putCoord(coordInsideLevel)
                .putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildBossRoom(final MutablePair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.BOSS)
                .putCoord(coordInsideLevel)
                .putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildTreasureRoom(final MutablePair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.TREASURE)
                .putCoord(coordInsideLevel)
                .putDoors(List.of(null /*doors*/))
                .build();
    }
    
    /**
     * Increment the room ID.
     */
    private void incrementRoomID() {
        this.id++;
    }
}
