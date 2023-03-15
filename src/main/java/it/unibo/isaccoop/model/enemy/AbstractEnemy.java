package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

/***/
public abstract class AbstractEnemy implements Enemy {

    private Pair<Integer, Integer> coords;

    /***/
    public AbstractEnemy() {
        this.coords = Pair.of(0, 0);
    }

    @Override
    public abstract void onHit();

    @Override
    public abstract void hit();

    @Override
    public abstract void move();

    @Override
    public final Pair<Integer, Integer> getCoords() {
        return this.coords;
    }

    /**
     * Method to set new coords to the enemy.
     *
     * @param coords new coords of the enemy as a {@link Pair}
     * */
    protected void setCoords(final Pair<Integer, Integer> coords) {
        this.coords = coords;
    }

}
