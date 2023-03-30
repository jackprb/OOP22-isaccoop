package it.unibo.isaccoop.model.room;

import it.unibo.isaccoop.model.player.Player;

/**
 * Interface that allows to create a {@link Level} dynamically.
 */
public interface LevelFactory {

    /**
     * Generates dynamically a {@link Level} made of a random number of {@link Room}s.
     * The level will have at least 6 rooms and at most 30.
     * 
     * @return the level created
     */
    Level createLevel();

    /**
     * Get the player.
     * @return the player
     */
    Player getPlayer();
}
