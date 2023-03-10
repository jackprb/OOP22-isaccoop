package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

/***/
public class EnemyWeaponShot {

    private final Pair<Integer, Integer> coords;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     * */
    public EnemyWeaponShot(final Pair<Integer, Integer> startPosition) {
        this.coords = startPosition;
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
