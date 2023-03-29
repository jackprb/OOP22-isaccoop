package it.unibo.isaccoop.model.enemy;

import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.player.PlayerStat;
import it.unibo.isaccoop.model.weapon.WeaponShot;

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
    void setHearts(Double damage);

    /**
     * @return the hearts of the enemy
     * */
    Double getHearts();
    /**
     *Get enemy weapon shots if available.
     *
     *@return enemy weapon shots as a list, empty list if shots not available
     * */
    List<WeaponShot> getWeaponShots();


}
