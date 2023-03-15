package it.unibo.isaccoop.model.spawn;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @param <Item>
 */
public class SpawnItem<Item> implements Spawn<Item> {
    private final List<Item> list;

    /**
     * 
     * @param list
     */
    public SpawnItem(List<Item> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    /**
     * @param elementToSpawn
     */
    @Override
    public void setPosition(Item elementToSpawn) {
        
    }

}
