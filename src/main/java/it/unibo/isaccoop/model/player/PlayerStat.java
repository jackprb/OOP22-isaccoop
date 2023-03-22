package it.unibo.isaccoop.model.player;

/**
 * Player statistic.
 * */
public interface PlayerStat {

    /**
     * @return the number of remaining hearts
     * */
    int getHeart();

    /**
     * @return the max number of available hearts
     * */
    int getMaxHeart();

    /**
     * @return the number of coins collected during the game
     * */
    int getCoin();

    /**
     * @return the speed of the player
     * */
    float getSpeed();

    /**
     * @return the damage that the player can do
     * */
    float getDamage();

    /**
     * @return the max range at which player can hit an enemy
     * */
    float getRange();

    /**
     * @return the time between two hit
     * */
    float getTears();

    /**
     * @param heart the new number of heart of the player
     * set the player's current hearts as a parameter
     * */
    void setHeart(int heart);

    /**
     * @param maxHeart the new number of available heart of the player
     * set the max available heart for the player
     * */
    void setMaxHeart(int maxHeart);

    /**
     * @param coin the coin collected during the game or used in the shop
     * set the coin of the player
     * */
    void setCoin(int coin);

    /**
     * @param range the range where the player can hit
     * set the new range
     * */
    void setRange(float range);

    /**
     * @param speed the new speed
     * set the new speed of the player
     * */
    void setSpeed(float speed);

    /**
     * @param tears
     * set the new time between two hit
     * */
    void setTears(float tears);

    /**
     * @param damage
     * set the new damage that player have
     * */
    void setDamage(float damage);

    /**
     * @return if the player is dead
     * */
    boolean isDead();
}
