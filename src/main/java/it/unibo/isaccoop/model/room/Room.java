package it.unibo.isaccoop.model.room;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.PowerUp;

/**
 * Interface to model the concept of Room inside the game.
 */
public interface Room extends MapElement {

    /**
     * Get the doors in this room.
     * @return the doors in this room
     */
    /*List<Door> getDoors();*/

    //TODO get per : lista powerup, obstacles, enemy, optional<Boss>

    /**
     * @return the type of this room
     */
    RoomType getRoomType();

    /**
     * Get {@link AIEnemy} attached to this {@link Room}.
     *
     * @return {@link AIEnemy} attached to this {@link Room}
     * */
    Optional<AIEnemy> getRoomAI();

    /**
     * Get the {@link Item}s in this room.
     * @return the list of items in this room
     */
    Optional<List<Item>> getItems();

    /**
     * Get the {@link PowerUp}s in this room.
     * @return the list of powerups in this room
     */
    Optional<List<PowerUp>> getPowerUps();

    /**
     * Check if this room is complete.
     * A room is complete if all enemies in there are defeated.
     * Rooms with neither enemies nor boss are already complete. 
     * @return true if this room is complete, false otherwise
     */
    boolean isComplete();
}
