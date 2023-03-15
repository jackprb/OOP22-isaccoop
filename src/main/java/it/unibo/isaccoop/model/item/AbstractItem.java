package it.unibo.isaccoop.model.item;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Abstract class that models items.
 * */
public abstract class AbstractItem extends AbstractMapElement implements Item {
    /**
     *
     * @param coords
     */
    public AbstractItem(Pair<Double, Double> coords) {
        super(coords);
    }

    /**
     *  Method that applies the item's effect to the player.
     *  @param p reference to the player.
     * */
    @Override
    public abstract void interact(PlayerStat p);


}
