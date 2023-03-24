package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.MapElement;

/***/
public interface Enemy extends EnemyActions, Hitable, MapElement {

    /**
     * Check if the enemy is dead.
     *
     * @return boolean check result
     * */
    boolean isDead();

}
