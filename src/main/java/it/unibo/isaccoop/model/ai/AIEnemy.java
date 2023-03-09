package it.unibo.isaccoop.model.ai;

/***/
public interface AIEnemy {

    /**
     * Method to spawn enemies into the room linked to AI impl.
     * */
    void spawnEnemies();

    /**
     * Method to perform enemies actions (move and hit) into the room linked to AI impl.
     * */
    void updateEnemies();

}
