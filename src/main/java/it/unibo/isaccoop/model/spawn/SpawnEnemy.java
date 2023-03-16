package it.unibo.isaccoop.model.spawn;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.enemy.Enemy;

/**
 *
 */
public class SpawnEnemy implements Spawn<Enemy> {
    private final List<Enemy> list;

    /**
     *
     * @param list
     */
    public SpawnEnemy(final List<Enemy> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    /**
     * @param elementToSpawn
     */
    @Override
    public void setPosition(final Enemy elementToSpawn) {
    }

}
