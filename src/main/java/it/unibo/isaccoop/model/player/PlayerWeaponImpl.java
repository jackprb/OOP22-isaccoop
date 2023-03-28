package it.unibo.isaccoop.model.player;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.Weapon;
import it.unibo.isaccoop.model.enemy.WeaponShot;

/**
 * Implements the PlayerWeapon.
 * */
public class PlayerWeaponImpl implements Weapon {

    private final List<WeaponShot> weaponShots;
    private long timeSinceLastShot;
    private Double tears;

    /**
     * Weapon constructor.
     * */
    public PlayerWeaponImpl(final Double tears) {
        this.weaponShots = new ArrayList<>();
        this.tears = tears;
    }

    /***/
    @Override
    public void remove(MapElement e) {
        this.weaponShots.remove(e);
    }

    /***/
    @Override
    public void shoot(Point2D startPosition, Vector2D direction) {
        if (System.currentTimeMillis() - timeSinceLastShot > this.tears) {
            this.weaponShots.add(new PlayerShot( direction, startPosition));
            this.timeSinceLastShot = System.currentTimeMillis();
        }
        this.weaponShots.forEach(shot -> shot.tickShot());
    }

    /***/
    @Override
    public List<WeaponShot> getWeaponShots() {
        return List.copyOf(this.weaponShots);
    }
}
