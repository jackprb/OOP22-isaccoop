package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.model.common.Point2D;

/***/
public final class NonShootingEnemy extends AbstractEnemy {

    private boolean canHit;

    /**
     * Constructor for {@link NonShootingEnemy}.
     * */
    public NonShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS, new NonShootingHitStrategy(), new NonShootingMovementStrategy());
        this.canHit = false;
    }

    @Override
    public void hit(final Point2D playerPosition) {
       super.getHitStrategy().shoot(Optional.empty(), this);
    }

    /***/
    @Override
    public void onShoot() {
        this.canHit = !this.canHit;
    }
}
