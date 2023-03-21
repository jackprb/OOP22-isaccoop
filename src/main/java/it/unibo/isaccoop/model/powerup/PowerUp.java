package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.item.AbstractItem;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the generic power up.
 * */
public abstract class PowerUp extends AbstractItem {

    private int price = 0;

    private boolean superItem;
    /**
     *  Method for interacting with player stats.
     *  @param p reference to player.
     * */
    @Override
    public abstract void interact(PlayerStat p);
    /**
     * @return true if is a super item
     * */
    public boolean isSuperItem() {
        return superItem;
    }
    /**
     * @param superItem true for change boolean variable
     * */
    public void setSuperItem(final boolean superItem) {
        this.superItem = superItem;
    }
    /**
     *
     * @return price of the powerUp.
     */
    public int getPrice() {
        return price;
    }
    /**
     * Set price to current powerUp.
     * @param price new price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

}
