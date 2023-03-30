package it.unibo.isaccoop.model.action;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.weapon.Weapon;
import it.unibo.isaccoop.model.weapon.WeaponShot;

/***/
public final class ShootingHitStrategy implements HitStrategy {

    private final Weapon weapon;

    /**
     * ShootingHitStrategy constructor.
     *
     * @param weapon weapon implementation to handle the shooting strategy
     * */
    public ShootingHitStrategy(final Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void hit(final Optional<Vector2D> direction, final MapElement caller) {
        this.weapon.shoot(caller.getCoords(), direction.get());
    }

    /**
     * Get weapon shots.
     *
     * @return weapon shots list
     * */
    public List<WeaponShot> getWeaponShots() {
        return List.copyOf(weapon.getWeaponShots());
    }
}