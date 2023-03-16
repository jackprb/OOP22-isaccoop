package it.unibo.isaccoop.model.spawn;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.item.Item;

/**
 * 
 */
public class SpawnItem implements Spawn<Item> {
    private final List<Item> list;

    /**
     * 
     * @param list
     */
    public SpawnItem(final List<Item> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    /**
     * @param elementToSpawn
     */
    @Override
    public void setPosition(final Item elementToSpawn) {
    }

}
