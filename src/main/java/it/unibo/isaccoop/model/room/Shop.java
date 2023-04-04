package it.unibo.isaccoop.model.room;

import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.powerup.PowerUp;

/**
 * 
 * Interface that models the purchase of items in the shop.
 *
 */
public interface Shop {

    /**
     * Method that applies the collected powerup to the player, if the player 
     * has enough coins to buy it.
     * @param player
     * @param powerUp
     * @return true if the power up has been purchased
     */
    Boolean buyItem(Player player, PowerUp powerUp);
}
