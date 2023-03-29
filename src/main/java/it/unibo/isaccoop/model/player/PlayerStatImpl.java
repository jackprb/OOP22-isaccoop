package it.unibo.isaccoop.model.player;

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
    private Double speed;

    /**
     * the time between two hit.
     * */
    private Double tears;

    /**
     * the damage that player deals.
     * */
    private Double damage;

    /**
     * the range where the player can hit.
     * */
    private Double range;

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
     * */
    public PlayerStatImpl() {
        super(ElementsRadius.PLAYER);
        this.heart = PlayerValue.HEART.getValue();
        this.coin = PlayerValue.COIN.getValue();
        this.maxHeart = PlayerValue.MAX_HEART.getValue();
        this.speed = Double.valueOf(PlayerValue.SPEED.getValue());
        this.tears = Double.valueOf(PlayerValue.TEARS.getValue());
        this.damage = Double.valueOf(PlayerValue.DAMAGE.getValue());
        this.range = Double.valueOf(PlayerValue.RANGE.getValue());
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
    public Double getSpeed() {
        return this.speed;
    }

    /**
     * @return the damage that the player can do
     */
    @Override
    public Double getDamage() {
        return this.damage;
    }

    /**
     * @return the max range at which player can hit an enemy
     * */
    @Override
    public Double getRange() {
        return this.range;
    }

    /**
     * @return the time between two hit
     * */
    @Override
    public Double getTears() {
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
    public void setRange(final Double range) {
        this.range = range;
    }

    /***/
    @Override
    public void setSpeed(final Double speed) {
        this.speed = speed;
    }

    /***/
    @Override
    public void setTears(final Double tears) {
        this.tears = tears;
    }

    /***/
    @Override
    public void setDamage(final Double damage) {
        this.damage = damage;
    }

    /**
     * @return if the player is dead.
     * */
    @Override
    public boolean isDead() {
        return this.heart == 0;
    }

    /**
     * @return if the player has exhausted the hearts.
     * */
    public boolean isHitted() {
        if (this.getHeart() >= 1) {
            this.setHeart(this.getHeart() - 1);
        }
        return this.isDead();
    }
}
