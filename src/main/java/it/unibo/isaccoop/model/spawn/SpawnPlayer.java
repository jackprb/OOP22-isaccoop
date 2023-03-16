package it.unibo.isaccoop.model.spawn;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 *
 */
public class SpawnPlayer implements Spawn<PlayerStat> {
    private final PlayerStat player;

    /**
     * 
     * @param player
     */
    public SpawnPlayer(final PlayerStat player) {
        this.player = player;
    }

    /**
     * @param elementToSpawn
     */
    @Override
    public void setPosition(final PlayerStat elementToSpawn) {
    }

}
