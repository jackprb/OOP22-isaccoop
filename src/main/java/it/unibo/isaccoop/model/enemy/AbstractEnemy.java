package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public abstract class AbstractEnemy extends AbstractMapElement implements Enemy {

    /**
     * Attribute used to update enemy position incrementally.
     * */
    private static final int SPEED = 10;

    /***/
    private MovementStrategy movementStrategy;

    /***/
    private HitStrategy hitStrategy;

    /**
     * Attribute used to store enemy hearts.
     * */
    private int hearts;

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
     *  Method to be called when a collision between player and enemy is detected, it decreases
     *  the player's hearts by on.
     *
     *  @param player event target
     * */
    @Override
    public void onHit(final PlayerStat player) {
        player.setHeart(player.getHeart() - 1);
    }

    /**
     *  Get current enemy hearts.
     *
     *  @return current hearts number
     * */
    protected int getHearts() {
        return this.hearts;
    }

    /**
     * Get enemy speed.
     *
     * @return enemy speed
     * */
    protected static int getSpeed() {
        return SPEED;
    }

    @Override
    public final boolean isDead() {
        return this.getHearts() == 0;
    }


    /**
     * Enum containing enemy max hearts configurations.
     * */
    protected enum EnemyHearts {
        /**
         * Enemy max hearts.
         * */
        ENEMY_HEARTS(3),

        /**
         * Boss max hearts.
         * */
        BOSS_HEARTS(8);

        private final int maxHearts;

        EnemyHearts(final int maxHearts) {
            this.maxHearts = maxHearts;
        }

        /**
         * Get enum max hearts number.
         *
         * @return max hearts number
         * */
        public int getMaxHearts() {
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

}
