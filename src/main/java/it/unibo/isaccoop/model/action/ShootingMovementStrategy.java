package it.unibo.isaccoop.model.action;

import it.unibo.isaccoop.model.common.Point2D;

/***/
public class ShootingMovementStrategy implements MovementStrategy {

    /***/
    @Override
    public Point2D move(final Point2D enemyPosition, final Point2D playerPosition) {
        return enemyPosition.sum(enemyPosition.sub(playerPosition).getNormalized());
    }
}
