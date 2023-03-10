package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;
/**
 * 
 * Interface that models the purchase of items in the shop.
 *
 */
public interface Shop {

    /**
     * Method that make the purchase.
     * 
     * @param heroPos
     */
    void buyItem(Pair<Integer, Integer> heroPos);
}
