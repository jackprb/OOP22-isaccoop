package it.unibo.isaccoop.model.action;

import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.boundingbox.RectBoundingBox;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.ShootingEnemy;

/***/
public class ShootingMovementStrategy implements MovementStrategy {

    private RectBoundingBox roomBoundingBix;

    public ShootingMovementStrategy(final RectBoundingBox roomBoundingBox) {
        this.roomBoundingBix = roomBoundingBox;
    }

    /***/
    @Override
    public Point2D move(final Point2D enemyPosition, final Point2D playerPosition) {
        var newPos = new Point2D(0, 0);

        do {
            newPos = new Point2D(enemyPosition.getX(), enemyPosition.getY());
            Vector2D moveVector = new Vector2D(
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.getSpeed(), ShootingEnemy.getSpeed()),
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.getSpeed(), ShootingEnemy.getSpeed()));
            newPos.sum(moveVector);
        } while(!(newPos.getX() < this.roomBoundingBix.getWidth() && newPos.getY() < this.roomBoundingBix.getHeight()));

        return newPos;
    }
}
