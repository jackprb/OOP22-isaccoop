package it.unibo.isaccoop.model.room;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link RoomFactory}.
 */
public final class RoomFactoryImpl implements RoomFactory {

    private static final int MIN_MAX_ROOM_DIMENSIONS = 200;
    private static final String ALREADY_GENERATED_ALL_ROOMS = "you have already generated all the required rooms";
    private static final String START_ROOM_MUST_BE_FIRST = "the START room must be the FIRST to be generated";
    private static final String BOSS_ROOM_MUST_BE_LAST = "the BOSS room must be the LAST to be generated";

    private final int width;
    private final int height;
    private Player player;
    private int roomCount = 0;
    private boolean alreadyCreatedBossRoom = false;
    private boolean alreadyCreatedStartRoom = false;
    private final int totalNumberOfRooms;

    /**
     * Constructor. No parameters needed.
     */
    public RoomFactoryImpl(final int totalNumberOfRooms) {
        this.width = MIN_MAX_ROOM_DIMENSIONS;
        this.height = MIN_MAX_ROOM_DIMENSIONS;
        this.totalNumberOfRooms = totalNumberOfRooms;
    }

    @Override
    public Room buildStartRoom(final Point2D coordInsideLevel) {
        if (this.roomCount == 0 && !this.alreadyCreatedStartRoom) {            
            incrementRoomCount();
            this.alreadyCreatedStartRoom = true;
            return new RoomBuilder.Builder(this.width, this.height)
                    .roomType(RoomType.START)
                    .putCoord(coordInsideLevel)
                    .putPlayer(player)
                    .build();
        }
        throw new IllegalStateException(START_ROOM_MUST_BE_FIRST);
    }

    @Override
    public Room buildStandardRoom(final Point2D coordInsideLevel) {
        if (this.roomCount < this.totalNumberOfRooms) {            
            incrementRoomCount();
            return new RoomBuilder.Builder(this.width, this.height)
                    .roomType(RoomType.STANDARD)
                    .putCoord(coordInsideLevel)
                    .putEnemies()
                    .putItems()
                    .build();
        }
        throw new IllegalStateException(ALREADY_GENERATED_ALL_ROOMS);
    }

    @Override
    public Room buildShopRoom(final Point2D coordInsideLevel) {
        if (this.roomCount < this.totalNumberOfRooms) {            
            incrementRoomCount();
            return new RoomBuilder.Builder(this.width, this.height)
                    .roomType(RoomType.SHOP)
                    .putCoord(coordInsideLevel)
                    .putPowerUps()
                    .build();
        }
        throw new IllegalStateException(ALREADY_GENERATED_ALL_ROOMS);
    }

    @Override
    public Room buildBossRoom(final Point2D coordInsideLevel) {
        if (this.roomCount == this.totalNumberOfRooms - 1 && !this.alreadyCreatedBossRoom) { 
            incrementRoomCount();
            this.alreadyCreatedBossRoom = true;
            return new RoomBuilder.Builder(this.width, this.height)
                    .roomType(RoomType.BOSS)
                    .putCoord(coordInsideLevel)
                    .putEnemies()
                    .build();
        }
        throw new IllegalStateException(BOSS_ROOM_MUST_BE_LAST);
    }

    @Override
    public Room buildTreasureRoom(final Point2D coordInsideLevel) {
        if (this.roomCount < this.totalNumberOfRooms) {            
            incrementRoomCount();
            return new RoomBuilder.Builder(this.width, this.height)
                    .roomType(RoomType.TREASURE)
                    .putCoord(coordInsideLevel)
                    .putPowerUps()
                    .build();
        }
        throw new IllegalStateException(ALREADY_GENERATED_ALL_ROOMS);
    }

    @Override
    public Room buildRoomOfType(final RoomType roomType, final Point2D coordInsideLevel) {
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

    /**
     * Increments the room count. Useful to check if a specified room can be generated in that index.
     * (START room must alway be the first, BOSS room the last)
     */
    private void incrementRoomCount() {
        this.roomCount++;
    }
}
