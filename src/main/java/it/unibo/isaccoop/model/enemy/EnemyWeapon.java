package it.unibo.isaccoop.model.enemy;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;

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
     *  @param playerPosition player position to shot in the player direction
     * */
    public void shoot(final Point2D enemyPosition, final Point2D playerPosition) {
        if (System.currentTimeMillis() - timeSinceLastShot > EnemyWeapon.SHOT_TIME_LIMIT) {
            this.weaponShots.add(new EnemyWeaponShot(enemyPosition, playerPosition));
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
