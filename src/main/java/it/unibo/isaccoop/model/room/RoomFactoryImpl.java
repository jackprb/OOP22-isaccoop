package it.unibo.isaccoop.model.room;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link RoomFactory}.
 */
public final class RoomFactoryImpl implements RoomFactory {

    private final int width;
    private final int height;
    private static final int MIN_MAX_ROOM_DIMENSIONS = 200;
    private final Player player;

    /**
     * Constructor. No parameters needed.
     */
    public RoomFactoryImpl() {
        this.width = MIN_MAX_ROOM_DIMENSIONS;
        this.height = MIN_MAX_ROOM_DIMENSIONS;
        this.player = new Player();
    }

    @Override
    public Room buildStartRoom(final Point2D coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.START)
                .putCoord(coordInsideLevel)
                .putPlayer(player)
                .build();
    }

    @Override
    public Room buildStandardRoom(final Point2D coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.STANDARD)
                .putCoord(coordInsideLevel)
                .putEnemies()
                .putItems()
                .build();
    }

    @Override
    public Room buildShopRoom(final Point2D coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.SHOP)
                .putCoord(coordInsideLevel)
                .putPowerUps()
                .build();
    }

    @Override
    public Room buildBossRoom(final Point2D coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.BOSS)
                .putCoord(coordInsideLevel)
                .putEnemies()
                .build();
    }

    @Override
    public Room buildTreasureRoom(final Point2D coordInsideLevel) {
        return new RoomBuilder.Builder(this.width, this.height)
                .roomType(RoomType.TREASURE)
                .putCoord(coordInsideLevel)
                .putPowerUps()
                .build();
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
}
