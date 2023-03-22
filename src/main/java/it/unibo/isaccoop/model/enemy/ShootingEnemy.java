package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public final class ShootingEnemy extends AbstractEnemy {

    private final EnemyWeapon weapon;

    /***/
    public ShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS);
        this.weapon = new EnemyWeapon();
    }

    @Override
    public void hit(final Point2D playerPosition) {
        this.weapon.shoot(super.getCoords(), playerPosition);
    }

    @Override
    public void move(final Point2D playerPosition) {
        final Vector2D moveVector = new Vector2D(
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.getSpeed(), ShootingEnemy.getSpeed()),
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.getSpeed(), ShootingEnemy.getSpeed()));
        super.setCoords(super.getCoords().sum(moveVector));
    }

    /**
     *  Get {@link EnemyWeapon} object for this {@link ShootingEnemy}.
     *
     *  @return {@link EnemyWeapon} for this {@link ShootingEnemy}
     * */
    public EnemyWeapon getWeapon() {
        return weapon;
    }

}
