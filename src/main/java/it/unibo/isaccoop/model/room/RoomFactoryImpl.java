package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link RoomFactory}.
 */
public final class RoomFactoryImpl implements RoomFactory {

    private int id;
    private final int width;
    private final int height;
    private static final int MIN_MAX_ROOM_DIMENSIONS = 200;

    /**
     * Constructor. No parameters needed.
     */
    public RoomFactoryImpl() {
        this.id = 0;
        this.width = MIN_MAX_ROOM_DIMENSIONS;
        this.height = MIN_MAX_ROOM_DIMENSIONS;
    }

    @Override
    public Room buildStartRoom(final Pair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.START)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildStandardRoom(final Pair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.STANDARD)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildShopRoom(final Pair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.SHOP)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildBossRoom(final Pair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.BOSS)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildTreasureRoom(final Pair<Integer, Integer> coordInsideLevel) {
        incrementRoomID();
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.TREASURE)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildRoomOfType(RoomType roomType, Pair<Integer, Integer> coordInsideLevel) {
        switch (roomType) {
        case START: {
            return buildStartRoom(coordInsideLevel);
        }
        case STANDARD: {
            return buildStandardRoom(coordInsideLevel);
        }
        case SHOP: {
            return buildShopRoom(coordInsideLevel);
        }
        case BOSS: {
            return buildBossRoom(coordInsideLevel);
        }
        case TREASURE: {
            return buildTreasureRoom(coordInsideLevel);
        }
        default:
            throw new IllegalArgumentException("Incorrect roomType value: " + roomType);
        }
    }

    /**
     * Increment the room ID.
     */
    private void incrementRoomID() {
        this.id++;
    }
}
