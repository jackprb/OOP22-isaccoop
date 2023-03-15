package it.unibo.isaccoop.model.item;

import it.unibo.isaccoop.model.player.PlayerStat;

//import org.apache.commons.lang3.tuple.Pair;
/**
 *      Abstract class that models items.
 * */
public abstract class AbstractItem implements Item {
    //private Pair<Integer, Integer> position;
    /**
     *
     * */
    @Override
    public abstract void interact(PlayerStat p);


}
