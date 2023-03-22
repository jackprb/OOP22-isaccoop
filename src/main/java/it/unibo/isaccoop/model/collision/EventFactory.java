package it.unibo.isaccoop.model.collision;

import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;

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
     * @param enemy player who fired
     * @return event created
     * */
    Event getEnemyShot(Enemy enemy);

    /**
     * Get a new event when a player is shot.
     *
     * @return event created
     * */
    Event getEnemyHitEvent();

}
