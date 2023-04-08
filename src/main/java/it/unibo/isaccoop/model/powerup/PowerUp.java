package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.model.item.AbstractItem;

/**
 * Represents the generic power up and the super powerUp.
 * */
public abstract class PowerUp extends AbstractItem {

    private static final int PRICE = 2;
    private static final int SUPER_PRICE = 4;

    private Boolean superItem;

    /**
     *
     * @param gr reference to GraphicsComponent.
     */
    public PowerUp(final GraphicsComponent gr) {
        super(gr);
    }

    /**
     * @return true if is a super item
     * */
    public Boolean isSuperItem() {
        return superItem;
    }

    /**
     * @param superItem true for change boolean variable
     */
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

    /**
     * Update super graphics to differentiate the power ups in the graphics.
     *
     * @param isSuper
     * @return GraphicsComponent refer to PowerUp
     */
    protected abstract GraphicsComponent updateSuperGraphics(Boolean isSuper);
}
