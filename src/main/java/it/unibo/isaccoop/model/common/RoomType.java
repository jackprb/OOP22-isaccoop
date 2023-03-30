package it.unibo.isaccoop.model.common;

import it.unibo.isaccoop.model.room.Room;

/**
 * Enum that models all the types of {@link Room} inside a {@link Level}.
 */
public enum RoomType {
    /**
     * An empty room where the player starts.
     */
    START, 
    /**
     * A room with enemies and obstacles.
     */
    STANDARD, 
    /**
     * A room where you can buy power ups.
     */
    SHOP, 
    /**
     * A room with the final boss.
     */
    BOSS, 
    /**
     * A room that contains a free power up.
     */
    TREASURE; 
}
