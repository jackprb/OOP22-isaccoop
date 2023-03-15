package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link RoomFactory}.
 */
public final class RoomFactoryImpl implements RoomFactory {

    private final int width;
    private final int height;
    private static final int MIN_MAX_ROOM_DIMENSIONS = 200;

    /**
     * Constructor. No parameters needed.
     */
    public RoomFactoryImpl() {
        this.width = MIN_MAX_ROOM_DIMENSIONS;
        this.height = MIN_MAX_ROOM_DIMENSIONS;
    }

    @Override
    public Room buildStartRoom(final Pair<Double, Double> coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.START)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildStandardRoom(final Pair<Double, Double> coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.STANDARD)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildShopRoom(final Pair<Double, Double> coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.SHOP)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildBossRoom(final Pair<Double, Double> coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.BOSS)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildTreasureRoom(final Pair<Double, Double> coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.TREASURE)
                .putCoord(coordInsideLevel)
                //.putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildRoomOfType(final RoomType roomType, final Pair<Double, Double> coordInsideLevel) {
        switch (roomType) {
        case START:
            return buildStartRoom(coordInsideLevel);
        case STANDARD:
            return buildStandardRoom(coordInsideLevel);
        case SHOP:
            return buildShopRoom(coordInsideLevel);
        case BOSS: 
            return buildBossRoom(coordInsideLevel);
        case TREASURE: 
            return buildTreasureRoom(coordInsideLevel);
        default:
            throw new IllegalArgumentException("Incorrect roomType value: " + roomType);
        }
    }
}
