package it.unibo.isaccoop.model.item;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Abstract class that models items.
 * */
public abstract class AbstractItem extends AbstractMapElement implements Item {

    /**
     * Constractor.
     */
    public AbstractItem() {
        super(ElementsRadius.ITEM);
        // TODO Auto-generated constructor stub
    }

    /**
     *  Method that applies the item's effect to the player.
     *  @param p reference to the player.
     * */
    @Override
    public abstract void interact(PlayerStat p);


}
