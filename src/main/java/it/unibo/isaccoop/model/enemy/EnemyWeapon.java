package it.unibo.isaccoop.model.enemy;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

/***/
public class EnemyWeapon {

    private final List<EnemyWeaponShot> weaponShots;
    private long timeSinceLastShot;
    private static final long SHOT_TIME_LIMIT = 1000;

    /**
     *  Constructor for {@link EnemyWeapon}.
     * */
    public EnemyWeapon() {
       this.weaponShots = new ArrayList<>();
    }

    /**
     *  Method to fire the {@link EnemyWeapon}, it creates a new shot if needed and it updates shots positions.
     *
     *  @param enemyPosition current enemy position as a {@link Pair} in order to
     *   set the starting shot position of the new shot
     * */
    public void shoot(final Pair<Integer, Integer> enemyPosition) {
        if (System.currentTimeMillis() - timeSinceLastShot > EnemyWeapon.SHOT_TIME_LIMIT) {
            this.weaponShots.add(new EnemyWeaponShot(enemyPosition));
            this.timeSinceLastShot = System.currentTimeMillis();
        }
        this.weaponShots.forEach(shot -> shot.tickShot());
    }

    /**
     * Get the {@link EnemyWeaponShot} list for this {@link EnemyWeapon}.
     *
     * @return {@link EnemyWeaponShot} list for this {@link EnemyWeapon} as {@link List}
     * */
    public List<EnemyWeaponShot> getWeaponShots() {
        return List.copyOf(this.weaponShots);
    }

}
