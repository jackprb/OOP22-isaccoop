package it.unibo.isaccoop.model.spawn;
/**
 *
 * @param <Player>
 */
public class SpawnPlayer<Player> implements Spawn<Player> {
    private final Player player;

    /**
     * 
     * @param player
     */
    public SpawnPlayer(Player player) {
        this.player = player;
    }

    /**
     * @param elementToSpawn
     */
    @Override
    public void setPosition(Player elementToSpawn) {
        
    }

}
