package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public class NonShootingMovementStrategy implements MovementStrategy {

    /***/
    @Override
    public Point2D move(final Point2D enemyPosition, final Point2D playerPosition) {
        final Vector2D movementVector = playerPosition.sub(enemyPosition).mul(1.0 / NonShootingEnemy.getSpeed());
        return enemyPosition.sum(movementVector);
    }
}
