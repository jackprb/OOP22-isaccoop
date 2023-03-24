package it.unibo.isaccoop.model.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.creator.ConcreteCreatorFactory;
import it.unibo.isaccoop.model.creator.CreatorFactory;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.room.RoomBuilder.Builder;
import it.unibo.isaccoop.model.spawn.SpawnOrdered;
import it.unibo.isaccoop.model.spawn.SpawnRandom;

/**
 * Delegated class that contains utility methods to help {@link RoomBuilder} creating 
 * a room.
 */
public final class RoomBuilderUtils {

    // factory that creates enemies, items and powerups
    private final CreatorFactory creatorFactory = new ConcreteCreatorFactory();
    private final RoomType roomType;

    /**
     * Create a RoomBuilderUtil object, to access utility methods.
     * @param roomType the type of the room
     */
    public RoomBuilderUtils(final RoomType roomType) {
        this.roomType = roomType;
    }

    /**
     * Check if the current room to build needs the AiEnemy object.
     * @return true if the room need the AiEnemy object, false otherwise
     */
    public boolean canRoomHavePlayer() {
        return this.roomType == RoomType.START;
    }

    /**
     * Check if the current room to build needs the AiEnemy object.
     * @return true if the room need the AiEnemy object, false otherwise
     */
    public boolean canRoomHaveEnemies() {
        return this.roomType == RoomType.STANDARD || this.roomType == RoomType.BOSS;
    }

    /**
     * Check if the current room to build can have powerups.
     * @return true if the room can have powerups, false otherwise
     */
    public boolean canRoomHavePowerUps() {
        return this.roomType == RoomType.SHOP || this.roomType == RoomType.TREASURE;
    }

    /**
     * Check if the current room to build can have items.
     * @return true if the room can have items, false otherwise
     */
    public boolean canRoomHaveItems() {
        return this.roomType == RoomType.STANDARD;
    }
}
