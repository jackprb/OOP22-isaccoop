package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;

/***/
public final class ShootingEnemy extends AbstractMapElement implements Enemy {

    private static final int DELTA = 10;
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
        final double newX = super.getCoords().getX()
                + ThreadLocalRandom.current().nextInt(-ShootingEnemy.DELTA, ShootingEnemy.DELTA);
        final double newY = super.getCoords().getY()
                + ThreadLocalRandom.current().nextInt(-ShootingEnemy.DELTA, ShootingEnemy.DELTA);
        super.setCoords(new Point2D(newX, newY));
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
