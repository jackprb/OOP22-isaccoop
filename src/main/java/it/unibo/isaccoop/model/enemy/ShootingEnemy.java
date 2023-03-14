package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

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
    public void hit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        super.setCoords(Pair.of(super.getCoords().getKey() + 10, super.getCoords().getKey() + 10));
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
