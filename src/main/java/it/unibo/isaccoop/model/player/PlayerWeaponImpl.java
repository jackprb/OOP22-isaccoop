package it.unibo.isaccoop.model.player;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;

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
     * the speed of the "bullet".
     * */
    private float speed;

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
     * @return the speed of the weapon
     * */
    @Override
    public float getSpeed() {
        return this.speed;
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
     * Set the speed of the "bullet".
     * @param speed the speed of the "bullet"
     * */
    @Override
    public void setSpeed(final float speed) {
        this.speed = speed;
    }

    /**
     * Weapon constructor.
     * @param direction the direction of the "bullet"
     * @param position the position of the "bullet"
     * @param damage the damage of the "bullet"
     * @param speed the speed of the "bullet"
     * */
    public PlayerWeaponImpl(final int direction, final Pair<Double, Double> position,
                            final float damage, final float speed) {
        super(position);
        this.direction = direction;
        this.damage = damage;
        /* lo speed del proiettile verrà trattato nella relazione, non verrà usato */
        this.speed = speed;
    }

}
