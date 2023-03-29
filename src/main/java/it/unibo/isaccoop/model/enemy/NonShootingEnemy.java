package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.action.NonShootingHitStrategy;
import it.unibo.isaccoop.model.action.NonShootingMovementStrategy;

/***/
public final class NonShootingEnemy  extends AbstractEnemy {

    /**
     * Constructor for {@link NonShootingEnemy}.
     * */
    public NonShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS, new NonShootingHitStrategy(), new NonShootingMovementStrategy());
    }

}
