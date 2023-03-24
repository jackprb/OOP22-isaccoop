package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public class ShootingMovementStrategy implements MovementStrategy {

    /***/
    @Override
    public Point2D move(final Point2D enemyPosition, final Point2D playerPosition) {
        final Vector2D moveVector = new Vector2D(
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.getSpeed(), ShootingEnemy.getSpeed()),
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.getSpeed(), ShootingEnemy.getSpeed()));
        return enemyPosition.sum(moveVector);
    }
}
