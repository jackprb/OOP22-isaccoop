package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.graphics.factory.ConcreteEnemyGraphicsComponentFactory;
import it.unibo.isaccoop.model.action.ShootingHitStrategy;
import it.unibo.isaccoop.model.action.ShootingMovementStrategy;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.weapon.BaseWeaponShot;
import it.unibo.isaccoop.model.weapon.TimeIntervalWeapon;

/***/
public final class ShootingEnemy extends AbstractEnemy {

    private static final double WEAPON_INTERVAL = 5000;

    /***/
    public ShootingEnemy() {
        super(EnemyHearts.ENEMY_HEARTS,
                new ShootingHitStrategy(new TimeIntervalWeapon(WEAPON_INTERVAL,
                        (start, direction) -> new BaseWeaponShot(start, direction, new ConcreteEnemyGraphicsComponentFactory().getEnemyBaseWeaponShotGraphicsComponent()))), new ShootingMovementStrategy(),
                new ConcreteEnemyGraphicsComponentFactory().getShootingGraphicsComponent());
    }

    @Override
    public void hit(final Point2D playerPosition) {
        super.getHitStrategy().hit(Optional.of(playerPosition.sub(super.getCoords())), this);
    }
}
