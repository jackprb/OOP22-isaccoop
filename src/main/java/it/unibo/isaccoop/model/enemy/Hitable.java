package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Generic Hitable subject.
 * */
public interface Hitable {

    /**
     * Method to be called when the culpable is hit.
     *
     * @param player player who fired
     * */
    void onHit(PlayerStat player);

}
