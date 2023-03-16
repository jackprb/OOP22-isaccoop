package it.unibo.isaccoop.model.player;

/**
 * The interface for the "bullet".
 * */
public interface PlayerWeapon {
    /**
     * @return the direction of the shot
     * */
    int getDirection();

    /**
     * @return the damage of the weapon
     * */
    float getDamage();

    /**
     * Set the new direction of the "bullet".
     * @param direction new direction
     * */
    void setDirection(int direction);

    /**
     * Set the damage it deals.
     * @param damage the damage it deal
     * */
    void setDamage(float damage);

}
