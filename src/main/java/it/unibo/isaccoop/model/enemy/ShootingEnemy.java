package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public final class ShootingEnemy extends AbstractEnemy {

    private final EnemyWeapon weapon;

    /***/
    public ShootingEnemy() {
        this.weapon = new EnemyWeapon();
    }

    @Override
    public void onHit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hit(final Point2D playerPosition) {
        this.weapon.shoot(super.getCoords(), playerPosition);
    }

    @Override
    public void move(final Point2D playerPosition) {
        final Vector2D moveVector = new Vector2D(
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.DELTA, ShootingEnemy.DELTA),
                ThreadLocalRandom.current().nextDouble(-ShootingEnemy.DELTA, ShootingEnemy.DELTA));
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
