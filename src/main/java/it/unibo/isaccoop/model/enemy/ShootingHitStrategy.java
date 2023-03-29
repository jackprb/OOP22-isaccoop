package it.unibo.isaccoop.model.enemy;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Vector2D;

/**
 * @param <E>*/
public final class ShootingHitStrategy implements HitStrategy {

    private final Weapon weapon;

    /***/
    public ShootingHitStrategy(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void hit(final Optional<Vector2D> direction, final MapElement caller) {
        this.weapon.shoot(caller.getCoords(), direction.get());
    }

    public List<WeaponShot> getWeaponShots() {
        return List.copyOf(weapon.getWeaponShots());
    }
}
