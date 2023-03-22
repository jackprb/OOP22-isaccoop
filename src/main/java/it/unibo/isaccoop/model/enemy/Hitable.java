package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Generic Hitable subject.
 * */
public interface Hitable {

    /**
     * Method to be called when the culpable is hit.
     *
     * @param player player object in order to handle collision with enemy
     * */
    void onHit(PlayerStat player);

}
