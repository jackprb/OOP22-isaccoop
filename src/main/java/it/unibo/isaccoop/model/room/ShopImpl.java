package it.unibo.isaccoop.model.room;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;


/**
 * Class that implements the Shop interface.
 * */
public class ShopImpl implements Shop {
    private final Map<Pair<Integer, Integer>, Integer> powerUPs = new HashMap<>();
    /**
     * @param powerUPs
     */
    public ShopImpl(final Map<Pair<Integer, Integer>, Integer> powerUPs) {
        this.powerUPs.putAll(powerUPs);
    }
 
    /**
     * Da fare.
     * @param heroPos
     */
    @Override
    public void buyItem(final Pair<Integer, Integer> heroPos) {
        //final var powerUP = this.powerUPs.get(heroPos);
        //powerUP.interact();
        this.powerUPs.remove(heroPos);
    }

}
