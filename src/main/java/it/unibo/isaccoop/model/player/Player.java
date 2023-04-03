package it.unibo.isaccoop.model.player;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.graphics.PlayerGraphicsComponents;
import it.unibo.isaccoop.model.action.HitStrategy;
import it.unibo.isaccoop.model.action.ShootingHitStrategy;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.enemy.Hitable;
import it.unibo.isaccoop.model.weapon.BaseWeaponShot;
import it.unibo.isaccoop.model.weapon.TimeIntervalWeapon;
import it.unibo.isaccoop.model.weapon.WeaponShot;

/**
 * The class for the player.
 * */
public class Player extends PlayerMovementImpl implements Hitable<Enemy> {

    private InputController movementController;
    private InputController shootingController;

    /***/
    private final HitStrategy hitStrategy;

    /**
     * Player constructor.
     * */
    public Player(final InputController moveController, final InputController shotController, final PlayerGraphicsComponents gr) {
        super(gr);
        this.hitStrategy = new ShootingHitStrategy(new TimeIntervalWeapon(super.getTears(),
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
     * */
    void hit(final Direction direction) {
        final Vector2D direct = new Vector2D(direction.getX(), direction.getY());
        this.hitStrategy.hit(Optional.of(direct), this);
    }

    /**
     * Get player weapon shots if available.
     *
     * @return weapon shots list or empty list if shots not available
     * */
    public List<WeaponShot> getWeaponShots() {
        return this.getHitStrategy() instanceof ShootingHitStrategy
            ? ((ShootingHitStrategy) this.getHitStrategy()).getWeaponShots()
            : List.of();
    }

    /**
     * Get player hit strategy.
     *
     * @return player hit strategy
     * */
    public HitStrategy getHitStrategy() {
        return this.hitStrategy;
    }

    /**
     * @param enemy
     * */
    @Override
    public void onHit(final Enemy enemy) {
        enemy.setHearts(this.getDamage());
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
