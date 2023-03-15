package it.unibo.isaccoop.model.enemy;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;

/***/
public class EnemyWeaponShot extends AbstractMapElement {

    private static final int DELTA = 10;
    private final boolean axis;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     * */
    public EnemyWeaponShot(final Pair<Double, Double> startPosition) {
        super(startPosition);
        this.axis = ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through random axis.
     * */
    public void tickShot() {
        final Pair<Double, Double> newCoords = this.axis
                ? Pair.of(super.getCoords().getLeft(), super.getCoords().getRight() + EnemyWeaponShot.DELTA)
                : Pair.of(super.getCoords().getLeft() + EnemyWeaponShot.DELTA, super.getCoords().getRight());
        super.setCoords(newCoords);
    }

}
