package it.unibo.isaccoop.model.player;

import java.util.Optional;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.model.common.Direction;
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

    private InputController movementController;
    private InputController shootingController;

    /***/
    final HitStrategy shootingHitStrategy;

    public Player(final InputController moveController, final InputController shotController){
        this.shootingHitStrategy = new ShootingHitStrategy(new TimeIntervalWeapon(this.getTears(),
                (start, direction) -> new BaseWeaponShot(start, direction)));
        this.movementController = moveController;
        this.shootingController = shotController;
    }

    /**
     * @param direction the direction in which the player moves
     * */
    void move(final Direction direction) {
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

    /**
     * 
     * @return the movement controller
     */
    public InputController getMovementController() {
        return this.movementController;
    }

    /**
     * 
     * @return the shooting controller
     */
    public InputController getShootingController() {
        return this.shootingController;
    }
}
