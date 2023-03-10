package it.unibo.isaccoop.model.room;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;


/**
 * 
 * */
public class Shop {
    private final Map<Pair<Integer, Integer>, Integer> powerUPs = new HashMap<>();
    /**
     * @param powerUPs
     * Generate of N_POWER_UP in the PowerUP list.
     */
    public Shop(final Map<Pair<Integer, Integer>, Integer> powerUPs) {
        this.powerUPs.putAll(powerUPs);
    }
 
    /**
     * 
     * @param heroPos
     */
    public void useItem(final Pair<Integer, Integer> heroPos) {
        //final var powerUP = this.powerUPs.get(heroPos);
        //powerUP.interact();
        this.powerUPs.remove(heroPos);
    }

}
