package it.unibo.isaccoop.model.enemy;

/***/
public final class NonShootingEnemy extends AbstractEnemy {

    /**
     * Constructor for {@link NonShootingEnemy}.
     * */
    public NonShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS, new NonShootingHitStrategy(), new NonShootingMovementStrategy());
    }

}
