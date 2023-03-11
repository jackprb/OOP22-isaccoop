package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

/***/
public class Enemy implements EnemyActions, Hitable {

    private final Pair<Integer, Integer> coords;

    /***/
    public Enemy() {
        this.coords = Pair.of(0, 0);
    }

    @Override
    public void onHit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub

    }

    /**
     * Get {@link Enemy} current coords.
     *
     * @return current enemy coords as a {@link Pair}
     * */
    public Pair<Integer, Integer> getCoords() {
        return this.coords;
    }

}
