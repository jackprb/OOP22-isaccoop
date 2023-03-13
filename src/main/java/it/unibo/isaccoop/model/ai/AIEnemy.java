package it.unibo.isaccoop.model.ai;

import java.util.List;

import it.unibo.isaccoop.model.enemy.Enemy;

/***/
public interface AIEnemy {

    /**
     * Method to attach enemies to AI.
     *
     * @param enemies input enemies to attach to AI as {@link List}
     * */
    void attachEnemies(List<Enemy> enemies);

    /**
     * Method to perform enemies actions (move and hit) into the room linked to AI implementation.
     * */
    void updateEnemies();

}
