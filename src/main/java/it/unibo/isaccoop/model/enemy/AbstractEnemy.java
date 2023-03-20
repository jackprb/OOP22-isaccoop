package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public abstract class AbstractEnemy extends AbstractMapElement implements Enemy {

    /**
     * Attribute used to update enemy position incrementally.
     * */
    protected static final int DELTA = 10;

    /**
     *  Method to be called when a collision between player and enemy is detected, it decreases
     *  the player's hearts by on.
     *
     *  @param player event target
     * */
    @Override
    public void onHit(final PlayerStat player) {
        player.setHeart(player.getHeart() - 1);
    }

}
