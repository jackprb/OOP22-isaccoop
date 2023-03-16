package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;

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
    public void hit(final Pair<Double, Double> playerPosition) {
        this.weapon.shoot(super.getCoords());
    }

    @Override
    public void move(final Pair<Double, Double> playerPosition) {
        final double newX = super.getCoords().getLeft()
                + ThreadLocalRandom.current().nextInt(-ShootingEnemy.DELTA, ShootingEnemy.DELTA);
        final double newY = super.getCoords().getRight()
                + ThreadLocalRandom.current().nextInt(-ShootingEnemy.DELTA, ShootingEnemy.DELTA);
        super.setCoords(Pair.of(newX, newY));
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
