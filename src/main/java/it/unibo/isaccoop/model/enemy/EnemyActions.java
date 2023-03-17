package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

/***/
public interface EnemyActions {

    /**
     * Perform hit action of a certain {@link AbstractEnemy}.
     *
     * @param playerPosition current player position
     * */
    void hit(Pair<Double, Double> playerPosition);

    /**
     * Perform move action of a certain {@link AbstractEnemy}.
     *
     * @param playerPosition current player position
     * */
    void move(Pair<Double, Double> playerPosition);

}
