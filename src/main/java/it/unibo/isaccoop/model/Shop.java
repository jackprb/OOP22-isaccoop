package it.unibo.isaccoop.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;


/**
 * 
 * */
public class Shop {
    private final Map<Pair<Integer, Integer>, Integer> powerUPs = new HashMap<>();
    private static final int N_POWER_UP = 3;
    /**
     * @param powerUPs
     * Generate of N_POWER_UP in the PowerUP list.
     */
    public Shop(Map<Pair<Integer, Integer>, Integer> powerUPs) {
        this.powerUPs.putAll(powerUPs);;
    }
    
    /**
     * 
     * @param heroPos
     */
    public void getItem(Pair<Integer, Integer> heroPos) {
        var powerUP = this.powerUPs.get(heroPos);
        //powerUP.interact();
        this.powerUPs.remove(heroPos);
    }
    
    
}
