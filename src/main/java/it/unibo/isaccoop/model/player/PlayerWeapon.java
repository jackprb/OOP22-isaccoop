package it.unibo.isaccoop.model.player;

import org.apache.commons.lang3.tuple.Pair;

/**
 * The interface for the "bullet".
 * */
public interface PlayerWeapon {
    /**
     * @return the direction of the shot
     * */
    int getDirection();

    /**
     * @return the height of the weapon
     * */
    float getHeight();

    /**
     * @return the width of the weapon
     * */
    float getWidth();

    /**
     * @return the damage of the weapon
     * */
    float getDamage();

    /**
     * @return the speed of the weapon
     * */
    float getSpeed();

    /**
     * @return the position of the weapon
     * */
    Pair<Double, Double> getPosition();

    /**
     * Set the new direction of the "bullet".
     * @param direction new direction
     * */
    void setDirection(int direction);

    /**
     * Set the height of the "bullet".
     * @param height the height of the "bullet"
     * */
    void setHeight(float height);

    /**
     * Set the width of the "bullet".
     * @param width the width of the "bullet"
     * */
    void setWidth(float width);

    /**
     * Set the damage it deals.
     * @param damage the damage it deal
     * */
    void setDamage(float damage);

    /**
     * Set the speed of the "bullet".
     * @param speed the speed of the "bullet"
     * */
    void setSpeed(float speed);

    /**
     * Set the position of the "bullet".
     * @param position the position of the bullet
     * */
    void setPosition(Pair<Double, Double> position);
}
