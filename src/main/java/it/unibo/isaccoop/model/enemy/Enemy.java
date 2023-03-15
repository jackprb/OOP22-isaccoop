package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

/***/
public interface Enemy extends EnemyActions, Hitable {

    /**
     * Get {@link Enemy} current coords.
     *
     * @return current enemy coords as a {@link Pair}
     * */
    Pair<Integer, Integer> getCoords();

}
