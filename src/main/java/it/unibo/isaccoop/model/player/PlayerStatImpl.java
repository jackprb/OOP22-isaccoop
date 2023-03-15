package it.unibo.isaccoop.model.player;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;

/**
 * Implement the interface PlayerStat.
 * */
public class PlayerStatImpl extends AbstractMapElement implements PlayerStat {

    /**
     * the player hearts.
     * */
    private int heart;

    /**
     * the player coin for shop.
     * */
    private int coin;

    /**
     * the player can increase the max number of available heart with power up.
     * */
    private int maxHeart;

    /**
     * the player speed in the game.
     * */
    private float speed;

    /**
     * the time between two hit.
     * */
    private float tears;

    /**
     * the damage that player deals.
     * */
    private float damage;

    /**
     * the range where the player can hit.
     * */
    private float range;

    /**
     * create an enum to set initial stats of player.
     * */
    private enum PlayerValue {

        HEART(3),
        COIN(0),
        MAX_HEART(3),
        SPEED(1),
        TEARS(1),
        DAMAGE(1),
        RANGE(1);

        private int value;

        /**
         * @param value
         * set the value.
         * */
         PlayerValue(final int value) {
            this.value = value;
        }

        /**
         * @return the value of enum value.
         * */
        public int getValue() {
            return this.value;
        }
    }

    /**
     * Player constructor. 
     * @param x the x position
     * @param y the y position
     * */
    public PlayerStatImpl(final double x, final double y) {
        super(Pair.of(x, y));
        this.heart = PlayerValue.HEART.getValue();
        this.coin = PlayerValue.COIN.getValue();
        this.maxHeart = PlayerValue.MAX_HEART.getValue();
        this.speed = PlayerValue.SPEED.getValue();
        this.tears = PlayerValue.TEARS.getValue();
        this.damage = PlayerValue.DAMAGE.getValue();
        this.range = PlayerValue.RANGE.getValue();
    }

    /**
     * @return the number of remaining hearts
     * */
    @Override
    public int getHeart() {
        return this.heart;
    }

    /**
     * @return the max number of available hearts
     * */
    @Override
    public int getMaxHeart() {
        return this.maxHeart;
    }

    /**
     * @return the number of coins collected during the game
     * */
    @Override
    public int getCoin() {
        return this.coin;
    }

    /**
     * @return the speed of the player
     * */
    @Override
    public float getSpeed() {
        return this.speed;
    }

    /**
     * @return the damage that the player can do
     */
    @Override
    public float getDamage() {
        return this.damage;
    }

    /**
     * @return the max range at which player can hit an enemy
     * */
    @Override
    public float getRange() {
        return this.range;
    }

    /**
     * @return the time between two hit
     * */
    @Override
    public float getTears() {
        return this.tears;
    }

    /***/
    @Override
    public void setHeart(final int heart) {
        this.heart = heart;
    }

    /***/
    @Override
    public void setMaxHeart(final int maxHeart) {
        this.maxHeart = maxHeart;
    }

    /***/
    @Override
    public void setCoin(final int coin) {
        this.coin = coin;
    }

    /***/
    @Override
    public void setRange(final float range) {
        this.range = range;
    }

    /***/
    @Override
    public void setSpeed(final float speed) {
        this.speed = speed;
    }

    /***/
    @Override
    public void setTears(final float tears) {
        this.tears = tears;
    }

    /***/
    @Override
    public void setDamage(final float damage) {
        this.damage = damage;
    }

}
