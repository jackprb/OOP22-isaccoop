package it.unibo.isaccoop.model.room;

import java.util.List;
import org.apache.commons.lang3.tuple.MutablePair;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link RoomFactory}.
 */
public final class RoomFactoryImpl implements RoomFactory {

    private final int id;
    private final int width;
    private final int height;
    private final MutablePair<Integer, Integer> coord;
    private static final int MIN_MAX_ROOM_DIMENSIONS = 200;

    /**
     * 
     * @param id id of this room
     * @param coord coordinate of this room inside the level
     */
    public RoomFactoryImpl(final int id, final MutablePair<Integer, Integer> coord) { 
        this.id = id;
        this.width = MIN_MAX_ROOM_DIMENSIONS;
        this.height = MIN_MAX_ROOM_DIMENSIONS;
        this.coord = coord;
    }

    @Override
    public Room buildStartRoom() {
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.START)
                .putCoord(coord)
                .putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildStandardRoom() {
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.STANDARD)
                .putCoord(coord)
                .putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildShopRoom() {
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.SHOP)
                .putCoord(coord)
                .putDoors(List.of(null /*doors*/))
                .build();
    }

    @Override
    public Room buildBossRoom() {
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.BOSS)
                .putCoord(coord)
                .putDoors(List.of(null /*doors*/))
                .putAI(null)
                .build();
    }

    @Override
    public Room buildTreasureRoom() {
        return new RoomBuilder.Builder(this.id, this.width, this.height)
                .roomType(RoomType.TREASURE)
                .putCoord(coord)
                .putDoors(List.of(null /*doors*/))
                .build();
    }
}
