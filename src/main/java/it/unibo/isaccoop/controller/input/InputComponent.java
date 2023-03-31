package it.unibo.isaccoop.controller.input;

import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.room.Room;

/**
 * 
 *
 */
public interface InputComponent {

    /**
     * @param player
     */
    void update(Player player, Room room);
}
