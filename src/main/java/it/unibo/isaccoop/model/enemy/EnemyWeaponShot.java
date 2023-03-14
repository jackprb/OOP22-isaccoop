package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.tuple.Pair;

/***/
public class EnemyWeaponShot {

    private static final int DELTA = 10;
    private Pair<Integer, Integer> coords;
    private final boolean axis;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     * */
    public EnemyWeaponShot(final Pair<Integer, Integer> startPosition) {
        this.coords = startPosition;
        this.axis = ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through random axis.
     * */
    public void tickShot() {
        final Pair<Integer, Integer> newCoords = this.axis
                ? Pair.of(this.coords.getLeft(), this.coords.getRight() + EnemyWeaponShot.DELTA)
                : Pair.of(this.coords.getLeft() + EnemyWeaponShot.DELTA, this.coords.getRight());
        this.coords = newCoords;
    }

    /**
     * Get {@link EnemyWeaponShot} current position.
     *
     * @return current {@link EnemyWeaponShot} position as a {@link Pair}
     * */
    public Pair<Integer, Integer> getCoords() {
        return coords;
    }

}
