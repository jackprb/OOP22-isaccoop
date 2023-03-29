package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.model.action.ShootingHitStrategy;
import it.unibo.isaccoop.model.action.ShootingMovementStrategy;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.weapon.BaseWeaponShot;
import it.unibo.isaccoop.model.weapon.TimeIntervalWeapon;

/***/
public final class ShootingEnemy extends AbstractEnemy {

    /***/
    public ShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS,
                new ShootingHitStrategy(new TimeIntervalWeapon(getSpeed(),
                        (start, direction) -> new BaseWeaponShot(start, direction))),
                new ShootingMovementStrategy());
    }

    @Override
    public void hit(final Point2D playerPosition) {
        super.getHitStrategy().hit(Optional.of(playerPosition.sub(super.getCoords())), this);
    }
}
