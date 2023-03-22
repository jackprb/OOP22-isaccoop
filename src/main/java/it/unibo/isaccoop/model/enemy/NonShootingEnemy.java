package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public final class NonShootingEnemy extends AbstractEnemy {

    @Override
    public void hit(final Point2D playerPosition) {
       //TODO
    }

    @Override
    public void move(final Point2D playerPosition) {
        final Vector2D movementVector = playerPosition.sub(playerPosition).mul(1 / NonShootingEnemy.DELTA);
        super.setCoords(super.getCoords().sum(movementVector));
    }

}
