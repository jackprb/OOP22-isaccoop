package it.unibo.isaccoop.model.collision;

import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public interface EventFactory {

    /**
     * Get a new event when a pickup is made.
     *
     * @param target item picked up
     * @return event created
     * */
    Event getItemPickUpEvent(Item target);

    /**
     * Get a new event when an enemy is shot.
     *
     * @param player player who fired
     * @return event created
     * */
    Event getEnemyShot(PlayerStat player);

    /**
     * Get a new event when a player is shot.
     *
     * @return event created
     * */
    Event getEnemyHitEvent();

}
