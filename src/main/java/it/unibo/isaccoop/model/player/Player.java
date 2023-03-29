package it.unibo.isaccoop.model.player;

import java.util.Optional;

import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.HitStrategy;
import it.unibo.isaccoop.model.enemy.Hitable;
import it.unibo.isaccoop.model.enemy.ShootingHitStrategy;
import it.unibo.isaccoop.model.weapon.BaseWeaponShot;
import it.unibo.isaccoop.model.weapon.TimeIntervalWeapon;

/**
 * The class for the player.
 * */
public class Player extends PlayerMovementImpl implements Hitable {

    /***/
    final HitStrategy shootingHitStrategy;

    public Player(){
        this.shootingHitStrategy = new ShootingHitStrategy(new TimeIntervalWeapon(this.getTears(),
                (start, direction) -> new BaseWeaponShot(start, direction)));
    }

    /**
     * @param direction the direction in which the player moves
     * */
    void move(final int direction) {
        super.update(direction);
    }

    /**
     * @param direction the direction in which the bullet is fired
     * @param distance the distance between the player and the end of the room
     * */
    void hit(final Optional<Vector2D> direction, final float distance) {
        this.shootingHitStrategy.hit(direction, this);
    }

    /**
     * @param player
     * */
    @Override
    public void onHit(final PlayerStat player) {
    }

}
