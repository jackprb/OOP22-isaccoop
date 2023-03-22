package it.unibo.isaccoop.model.ai;

import it.unibo.isaccoop.model.common.MapElement;

/***/
public interface AIEnemy {

    /**
     * Method to perform enemies actions (move and hit) into the room linked to AI implementation.
     *
     * @param player player in game in order to handle enemy actions
     * */
    void updateEnemies(MapElement player);

}
