package it.unibo.isaccoop.model.item;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Abstract class that models items.
 * */
public abstract class AbstractItem implements Item {
    /**
     *  Method that applies the item's effect to the player.
     *  @param p reference to the player.
     * */
    @Override
    public abstract void interact(PlayerStat p);


}
