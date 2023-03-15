package it.unibo.isaccoop.model.player;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Implements the PlayerWeapon.
 * */
public class PlayerWeaponImpl implements PlayerWeapon {
    /**
     * the direction in which the "bullet" is fired.
     * */
    private int direction;

    /**
     * the height of the "bullet".
     * */
    private float height;

    /**
     * the width of the "bullet".
     * */
    private float width;

    /**
     * the damage of the "bullet".
     * */
    private float damage;

    /**
     * the speed of the "bullet".
     * */
    private float speed;

    /**
     * the position of the "bullet".
     * */
    private Pair<Double, Double> position;

    /**
     * @return the direction of the shot
     * */
    @Override
    public int getDirection() {
        return this.direction;
    }

    /**
     * @return the height of the weapon
     * */
    @Override
    public float getHeight() {
        return this.height;
    }

    /**
     * @return the width of the weapon
     * */
    @Override
    public float getWidth() {
        return this.width;
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
     * @return the position of the weapon
     * */
    @Override
    public Pair<Double, Double> getPosition() {
        return this.position;
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
     * Set the height of the "bullet".
     * @param height the height of the "bullet"
     * */
    @Override
    public void setHeight(final float height) {
        this.height = height;
    }

    /**
     * Set the width of the "bullet".
     * @param width the width of the "bullet"
     * */
    @Override
    public void setWidth(final float width) {
        this.width = width;
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
     * Set the position of the "bullet".
     * @param position the current position
     * */
    @Override
    public void setPosition(final Pair<Double, Double> position) {
        this.position = position;
    }

    /**
     * Weapon constructor.
     * @param direction the direction of the "bullet"
     * @param position the position of the "bullet"
     * @param height the height of the "bullet"
     * @param width the width of the "bullet"
     * @param damage the damage of the "bullet"
     * @param speed the speed of the "bullet"
     * */
    public PlayerWeaponImpl(final int direction, final Pair<Double, Double> position,
                            final float height, final float width, final float damage, final float speed) {
        this.direction = direction;
        this.position = position;
        this.height = height;
        this.width = width;
        this.damage = damage;
        /* lo speed del proiettile verrà trattato nella relazione, non serve implementarlo */
        this.speed = speed;
    }

}
