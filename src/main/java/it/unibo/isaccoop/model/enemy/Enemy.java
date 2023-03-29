package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public interface Enemy extends EnemyActions, Hitable<PlayerStat>, MapElement {

    /**
     * Check if the enemy is dead.
     *
     * @return boolean check result
     * */
    boolean isDead();

    /**
     * @param damage
     * */
    void setHearts(final Double damage);

    /**
     * @return the hearts of the enemy
     * */
    Double getHearts();

}
