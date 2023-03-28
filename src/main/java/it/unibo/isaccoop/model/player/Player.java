package it.unibo.isaccoop.model.player;

import java.util.Optional;

import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.HitStrategy;
import it.unibo.isaccoop.model.enemy.Hitable;
import it.unibo.isaccoop.model.enemy.ShootingHitStrategy;

/**
 * The class for the player.
 * */
public class Player extends PlayerMovementImpl implements Hitable {

    /***/
    final HitStrategy shootingHitStrategy;

    public Player(){
        this.shootingHitStrategy = new ShootingHitStrategy();
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
        this.shootingHitStrategy.shoot(direction, this);
    }

    /**
     * @param player
     * */
    @Override
    public void onHit(final PlayerStat player) {
    }

}
