package it.unibo.isaccoop.model.enemy;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public class EnemyWeapon implements Weapon {

    private final List<WeaponShot> weaponShots;
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
     *  @param direction to shoot in the player direction
     * */
    @Override
    public void shoot(final Point2D enemyPosition, final Vector2D direction) {
        if (System.currentTimeMillis() - timeSinceLastShot > EnemyWeapon.SHOT_TIME_LIMIT) {
            this.weaponShots.add(new EnemyWeaponShot(enemyPosition, direction));
            this.timeSinceLastShot = System.currentTimeMillis();
        }
        this.weaponShots.forEach(shot -> shot.tickShot());
    }

    /**
     * Get the {@link EnemyWeaponShot} list for this {@link EnemyWeapon}.
     *
     * @return {@link EnemyWeaponShot} list for this {@link EnemyWeapon} as {@link List}
     * */
    @Override
    public List<WeaponShot> getWeaponShots() {
        return List.copyOf(this.weaponShots);
    }

    /**
     * Remove the bullet 'e' from the list.
     * @param e
     */
    @Override
    public void remove(final MapElement e) {
        this.weaponShots.remove(e);
    }

}
