package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public final class NonShootingEnemy extends AbstractEnemy {

    private boolean canHit;
    private long lastHitTime;
    private static final int HIT_TIME = 1000;

    /**
     * Constructor for {@link NonShootingEnemy}.
     * */
    public NonShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS);
        this.canHit = false;
        this.lastHitTime = System.currentTimeMillis();
    }

    @Override
    public void hit(final Point2D playerPosition) {
       if (System.currentTimeMillis() - this.lastHitTime >= NonShootingEnemy.HIT_TIME) {
           this.canHit = !this.canHit;
           this.lastHitTime = System.currentTimeMillis();
       }
    }

    @Override
    public void move(final Point2D playerPosition) {
        final Vector2D movementVector = playerPosition.sub(playerPosition).mul(1.0 / NonShootingEnemy.getSpeed());
        super.setCoords(super.getCoords().sum(movementVector));
    }

}
