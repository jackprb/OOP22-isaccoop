package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.MutablePair;

/**
 * A façade interface to simplify the creation of {@link Room}, using {@link RoomBuilder}.
 */
public interface RoomFactory {

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return an empty room where the protagonist starts the game.
     */
    Room buildStartRoom(final MutablePair<Integer, Integer> coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room with enemies, obstacles and doors.
     */
    Room buildStandardRoom(final MutablePair<Integer, Integer> coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room where you can ONLY buy powerups using the collected money.
     */
    Room buildShopRoom(final MutablePair<Integer, Integer> coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return the room with the final boss
     */
    Room buildBossRoom(final MutablePair<Integer, Integer> coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room where you can find a free powerup
     */
    Room buildTreasureRoom(final MutablePair<Integer, Integer> coordInsideLevel);
}
