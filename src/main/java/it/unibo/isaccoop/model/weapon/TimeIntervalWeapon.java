package it.unibo.isaccoop.model.weapon;

import java.util.function.BiFunction;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.WeaponShot;

public class TimeIntervalWeapon extends AbstractWeapon {

    private BiFunction<Point2D, Vector2D, WeaponShot> weaponShotSupplier;
    private long timeSinceLastShot;
    private final Double shotTimeInterval;

    public TimeIntervalWeapon(final Double shotTimeInterval, final BiFunction<Point2D, Vector2D, WeaponShot> weaponShotSupplier) {
        this.weaponShotSupplier = weaponShotSupplier;
        this.timeSinceLastShot = System.currentTimeMillis();
        this.shotTimeInterval = shotTimeInterval;
    }

    @Override
    public void shoot(Point2D startPosition, Vector2D direction) {
        if (System.currentTimeMillis() - this.timeSinceLastShot > this.shotTimeInterval) {
            super.weaponShots.add(this.weaponShotSupplier.apply(startPosition, direction));
            this.timeSinceLastShot = System.currentTimeMillis();
        }
        super.weaponShots.forEach(shot -> shot.tickShot());
    }



}
