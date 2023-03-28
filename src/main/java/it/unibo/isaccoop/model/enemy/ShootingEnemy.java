package it.unibo.isaccoop.model.enemy;

import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;

/***/
public final class ShootingEnemy extends AbstractEnemy {

    /***/
    public ShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS, new ShootingHitStrategy(), new ShootingMovementStrategy());
    }

    @Override
    public void hit(final Point2D playerPosition) {

    }

    /**
     *  Get weapon shots of current shooting enemy.
     *
     *  @return enemy weapon shots as a {@link List}
     * */
    public List<EnemyWeaponShot> getWeaponShots() {
        return List.of();
    }

}
