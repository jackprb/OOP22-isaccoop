package it.unibo.isaccoop.model.enemy;

import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;

/***/
public final class ShootingEnemy extends AbstractEnemy {

    private final EnemyWeapon weapon;

    /***/
    public ShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS, new ShootingHitStrategy(), new ShootingMovementStrategy());
        this.weapon = new EnemyWeapon();
    }

    @Override
    public void hit(final Point2D playerPosition) {
        this.weapon.shoot(super.getCoords(), playerPosition);
    }

    /**
     *  Get weapon shots of current shooting enemy.
     *
     *  @return enemy weapon shots as a {@link List}
     * */
    public List<EnemyWeaponShot> getWeaponShots() {
        return this.weapon.getWeaponShots();
    }

    @Override
    public void onShoot() {

    }

}
