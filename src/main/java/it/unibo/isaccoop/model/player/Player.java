package it.unibo.isaccoop.model.player;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.enemy.HitStrategy;
import it.unibo.isaccoop.model.enemy.Hitable;
import it.unibo.isaccoop.model.enemy.ShootingHitStrategy;
import it.unibo.isaccoop.model.weapon.BaseWeaponShot;
import it.unibo.isaccoop.model.weapon.TimeIntervalWeapon;
import it.unibo.isaccoop.model.weapon.WeaponShot;

/**
 * The class for the player.
 * @param <E>
 * */
public class Player extends PlayerMovementImpl implements Hitable<Enemy> {

    private InputController controller;

    /***/
    private final HitStrategy hitStrategy;

    /**
     * Player constructor.
     * */
    public Player() {
        this.hitStrategy = new ShootingHitStrategy(new TimeIntervalWeapon(super.getTears(),
                (start, direction) -> new BaseWeaponShot(start, direction)));
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
    void hit(final Optional<Vector2D> direction, final float distance) {
        this.hitStrategy.hit(direction, this);
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
     * @param entity
     * */
    @Override
    public void onHit(final Enemy enemy) {
        enemy.setHearts(this.getDamage());
    }

    /**
     *
     * @return the controller
     */
    public InputController getController() {
        return this.controller;
    }
}
