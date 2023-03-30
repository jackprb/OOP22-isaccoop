package it.unibo.isaccoop.model.enemy;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.action.HitStrategy;
import it.unibo.isaccoop.model.action.MovementStrategy;
import it.unibo.isaccoop.model.action.ShootingHitStrategy;
import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.PlayerStat;
import it.unibo.isaccoop.model.weapon.WeaponShot;

/***/
public abstract class AbstractEnemy extends AbstractMapElement implements Enemy {

    /**
     * Attribute used to update enemy position incrementally.
     * */
    private static final Double SPEED = 10.0;

    /***/
    private MovementStrategy movementStrategy;

    /***/
    private HitStrategy hitStrategy;

    /**
     * Attribute used to store enemy hearts.
     * */
    private Double hearts;

    /**
     * Constructor for {@link AbstractEnemy}.
     *
     * @param maxHearts max hearts number for the enemy
     * @param hitStrategy the strategy for the hit
     * @param movementStrategy the strategy for the movement
     * */
    public AbstractEnemy(final EnemyHearts maxHearts, final HitStrategy hitStrategy, final MovementStrategy movementStrategy) {
        super(ElementsRadius.ENEMY);
        this.hitStrategy = hitStrategy;
        this.movementStrategy = movementStrategy;
        this.hearts = maxHearts.getMaxHearts();
    }

    /**
     * Delegates movement to {@link MovementStrategy}.
     *
     * @param playerPosition in order to move towards the player if needed
     * */
    @Override
    public void move(final Point2D playerPosition) {
        final Point2D newPos = this.getMovementStrategy().move(super.getCoords(), playerPosition);
        super.setCoords(newPos);
    }

    /**
     * Delegates hit to {@link HitStrategy}.
     *
     * @param playerPosition in order to hit towards the player if needed
     * */
    @Override
    public void hit(final Point2D playerPosition) {
        this.hitStrategy.hit(Optional.empty(), this);
    }

    /**
     *  Method to be called when a collision between player and enemy is detected, it decreases
     *  the player's hearts by on.
     *
     *  @param player event target
     * */
    @Override
    public void onHit(final PlayerStat player) {
        player.setHeart(player.getHeart() - 1);
    }

    /***/
    @Override
    public List<WeaponShot> getWeaponShots() {
        return this.getHitStrategy() instanceof ShootingHitStrategy
            ? ((ShootingHitStrategy) this.getHitStrategy()).getWeaponShots()
            : List.of();
    }

    /**
     *  Get current enemy hearts.
     *
     *  @return current hearts number
     * */
    @Override
    public Double getHearts() {
        return this.hearts;
    }

    /**
     * Get enemy speed.
     *
     * @return enemy speed
     * */
    public static double getSpeed() {
        return SPEED;
    }

    @Override
    public final boolean isDead() {
        return this.getHearts() <= 0;
    }


    /**
     * Enum containing enemy max hearts configurations.
     * */
    protected enum EnemyHearts {
        /**
         * Enemy max hearts.
         * */
        ENEMY_HEARTS(3.0),

        /**
         * Boss max hearts.
         * */
        BOSS_HEARTS(8.0);

        private final Double maxHearts;

        EnemyHearts(final Double maxHearts) {
            this.maxHearts = maxHearts;
        }

        /**
         * Get enum max hearts number.
         *
         * @return max hearts number
         * */
        public Double getMaxHearts() {
            return this.maxHearts;
        }
    }

    /**
     * @return the strategy of the hit
     * */
    public HitStrategy getHitStrategy() {
        return this.hitStrategy;
    }

    /**
     * @return the strategy of the movement
     * */
    public MovementStrategy getMovementStrategy() {
        return this.movementStrategy;
    }

    /**
     * @param movementStrategy
     * */
    public void setMovementStrategy(final MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    /**
     * @param hitStrategy
     * */
    public void setHitStrategy(final HitStrategy hitStrategy) {
        this.hitStrategy = hitStrategy;
    }

    /**
     * @param hearts
     * */
    @Override
    public void setHearts(final Double hearts) {
        if (!this.isDead()) {
            this.hearts -= hearts;
        }
    }
}
