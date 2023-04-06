package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.boundingbox.BoundingBox;
import it.unibo.isaccoop.model.common.Point2D;

/***/
public interface EnemyActions {

    /**
     * Perform hit action of a certain {@link AbstractEnemy}.
     *
     * @param playerPosition current player position
     * */
    void hit(Point2D playerPosition);

    /**
     * Perform move action of a certain {@link AbstractEnemy}.
     *
     * @param playerPosition current player position
     * */
    void move(Point2D playerPosition, BoundingBox containerBox);

}
