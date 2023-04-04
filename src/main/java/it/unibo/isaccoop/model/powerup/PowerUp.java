package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.model.item.AbstractItem;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the generic power up and the super powerUp.
 * */
public abstract class PowerUp extends AbstractItem {

    private static final int PRICE = 5;
    private static final int SUPER_PRICE = 10;

    private static boolean superItem;

    /***/
    public PowerUp(GraphicsComponent gr) {
        super(gr);
    }

    /**
     *  Method for interacting with player stats.
     *  @param p reference to player.
     * */
    @Override
    public abstract void interact(PlayerStat p);
    /**
     * @return true if is a super item
     * */
    public static boolean isSuperItem() {
        return superItem;
    }
    /**
     * @param superItem true for change boolean variable
     * */
    public void setSuperItem(final boolean superItem) {
        PowerUp.superItem = superItem;
    }
    /**
     *
     * @return price of the powerUp.
     */
    public int getPrice() {
        return PowerUp.isSuperItem() ? PowerUp.SUPER_PRICE : PowerUp.PRICE;
    }

}
