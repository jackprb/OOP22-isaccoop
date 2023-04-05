package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.model.item.AbstractItem;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the generic power up and the super powerUp.
 * */
public abstract class PowerUp extends AbstractItem {

    private static final int PRICE = 3;
    private static final int SUPER_PRICE = 8;

    private Boolean superItem;

    /**
     *
     * @param gr reference to GraphicsComponent.
     */
    public PowerUp(final GraphicsComponent gr) {
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
    public Boolean isSuperItem() {
        return superItem;
    }
    /**
     * @param superItem true for change boolean variable
     * */
    public void setSuperItem(final Boolean superItem) {
        super.setGraphicsComponents(updateSuperGraphics(superItem));
        this.superItem = superItem;
    }
    /**
     *
     * @return price of the powerUp.
     */
    public int getPrice() {
        return this.isSuperItem() ? PowerUp.SUPER_PRICE : PowerUp.PRICE;
    }

    /***/
    protected abstract GraphicsComponent updateSuperGraphics(Boolean isSuper);

}
