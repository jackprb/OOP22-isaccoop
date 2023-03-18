package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * A façade interface to simplify the creation of {@link Room}, using {@link RoomBuilder}.
 */
public interface RoomFactory {

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return an empty room where the protagonist starts the game.
     */
    Room buildStartRoom(Point2D coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room with enemies, obstacles and doors.
     */
    Room buildStandardRoom(Point2D coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room where you can ONLY buy powerups using the collected money.
     */
    Room buildShopRoom(Point2D coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return the room with the final boss
     */
    Room buildBossRoom(Point2D coordInsideLevel);

    /** 
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room where you can find a free powerup
     */
    Room buildTreasureRoom(Point2D coordInsideLevel);

    /** 
     * @param roomType type of the room to be created
     * @param coordInsideLevel the coordinate of this room inside the level
     * @return a room where you can find a free powerup
     */
    Room buildRoomOfType(RoomType roomType, Point2D coordInsideLevel);
}
