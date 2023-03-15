package it.unibo.isaccoop.model.spawn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <Enemy>
 */
public class SpawnEnemy<Enemy> implements Spawn<Enemy> {
    private final List<Enemy> list;

    /**
     *
     * @param list
     */
    public SpawnEnemy(List<Enemy> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    /**
     * @param elementToSpawn
     */
    @Override
    public void setPosition(Enemy elementToSpawn) {
        // TODO Auto-generated method stub
        
    }

}
