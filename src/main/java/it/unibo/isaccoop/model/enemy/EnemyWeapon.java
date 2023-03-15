package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

/***/
public class EnemyWeapon {

    private EnemyWeaponShot weaponShot;

    /**
     *  Method to fire the {@link EnemyWeapon}.
     *
     *  @param enemyPosition current enemy position as a {@link Pair} in order to
     *   set the starting shot position
     * */
    public void shoot(final Pair<Integer, Integer> enemyPosition) {
        this.weaponShot = new EnemyWeaponShot(enemyPosition);
    }

    /**
     * Get the {@link EnemyWeaponShot} for this {@link EnemyWeapon}.
     *
     * @return {@link EnemyWeaponShot} for this {@link EnemyWeapon}
     * */
    public EnemyWeaponShot getWeaponShot() {
        return weaponShot;
    }

}
