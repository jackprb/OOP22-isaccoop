package it.unibo.isaccoop.model.room;

/**
 * A façade interface to simplify the creation of {@link Room}, using {@link RoomBuilder}.
 */
public interface RoomFactory {

    /**
     * @return an empty room where the protagonist starts the game.
     */
    Room buildStartRoom();

    /**
     * @return a room with enemies, obstacles and doors.
     */
    Room buildStandardRoom();

    /**
     * @return a room where you can ONLY buy powerups using the collected money.
     */
    Room buildShopRoom();

    /**
     * @return the room with the final boss
     */
    Room buildBossRoom();

    /**
     * @return a room where you can find a free powerup
     */
    Room buildTreasureRoom();
}
