package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.model.common.Point2D;

/***/
public final class NonShootingEnemy extends AbstractEnemy {

    /**
     * Constructor for {@link NonShootingEnemy}.
     * */
    public NonShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS, new NonShootingHitStrategy(), new NonShootingMovementStrategy());
    }

    @Override
    public void hit(final Point2D playerPosition) {
       super.getHitStrategy().shoot(Optional.empty(), this);
    }

}
