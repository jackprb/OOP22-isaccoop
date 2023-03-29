package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public final class NonShootingHitStrategy implements HitStrategy {

    private boolean canHit;
    private long lastHitTime;
    private static final int HIT_TIME = 1000;

    /**
     * Constructor.
     * */
    public NonShootingHitStrategy() {
        this.canHit = false;
        this.lastHitTime = System.currentTimeMillis();
    }

    @Override
    public void hit(final Optional<Vector2D> direction, final MapElement caller) {
        if (System.currentTimeMillis() - this.lastHitTime >= NonShootingHitStrategy.HIT_TIME) {
            this.canHit = !this.canHit;
            this.lastHitTime = System.currentTimeMillis();
        }
    }

}
