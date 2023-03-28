package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public final class ShootingHitStrategy implements HitStrategy {

    private final Weapon weapon;

    /***/
    public ShootingHitStrategy() {
        this.weapon = new EnemyWeapon();
    }

    @Override
    public <E extends MapElement> void shoot(final Optional<Vector2D> direction, final E caller) {
        this.weapon.shoot(caller.getCoords(), direction.get());
    }
}
