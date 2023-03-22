package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;

/**
 * Implements the PlayerWeapon.
 * */
public class PlayerWeaponImpl extends AbstractMapElement implements PlayerWeapon {
    /**
     * the direction in which the "bullet" is fired.
     * */
    private int direction;

    /**
     * the damage of the "bullet".
     * */
    private float damage;

    /**
     * @return the direction of the shot
     * */
    @Override
    public int getDirection() {
        return this.direction;
    }

    /**
     * @return the damage of the weapon
     * */
    @Override
    public float getDamage() {
        return this.damage;
    }

    /**
     * Set the new direction of the "bullet".
     * @param direction new direction
     * */
    @Override
    public void setDirection(final int direction) {
        this.direction = direction;
    }

    /**
     * Set the damage it deals.
     * @param damage the damage of the "bullet"
     * */
    @Override
    public void setDamage(final float damage) {
        this.damage = damage;
    }

    /**
     * Weapon constructor.
     * @param direction the direction of the "bullet"
     * @param position the position of the "bullet"
     * @param damage the damage of the "bullet"
     * */
    public PlayerWeaponImpl(final int direction, final Point2D position, final float damage) {
        super(position, ElementsRadius.BULLET);
        this.direction = direction;
        this.damage = damage;
    }

}
