package it.unibo.isaccoop.model.collision;
/**
 *
 * Factory for collision check.
 *
 */
public interface CollisionCheckFactory {
    /**
     *  Get collision with item.
     * @return CollisionCheck refer to item.
     */
    CollisionCheck getCollisionWithItemChecker();
    /**
     *  Get collision with player shot.
     * @return CollisionCheck refer to player shot.
     */
    CollisionCheck getCollisionPlayerShotChecker();
    /**
     *  Get collision with enemy.
     * @return CollisionCheck refer to enemy.
     */
    CollisionCheck getCollisionWithEnemyChecker();
    /**
     *  Get collision with enemy shot.
     * @return CollisionCheck refer to enemy shot.
     */
    CollisionCheck getCollisionWithEnemyShotChecker();
}
