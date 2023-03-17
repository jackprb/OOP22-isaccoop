package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;

/***/
public class EnemyWeaponShot extends AbstractMapElement {

    private static final int DELTA = 10;
    private final ShotAxes axis;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     *  @param playerPosition player position in order to set the shot axis
     * */
    public EnemyWeaponShot(final Pair<Double, Double> startPosition, final Pair<Double, Double> playerPosition) {
        super(startPosition);
        this.axis = Math.abs(playerPosition.getLeft() - startPosition.getLeft())
                <= Math.abs(playerPosition.getRight() - startPosition.getRight())
                ? ShotAxes.X
                : ShotAxes.Y;
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through random axis.
     * */
    public void tickShot() {
        final Pair<Double, Double> newCoords = this.axis.equals(ShotAxes.Y)
                ? Pair.of(super.getCoords().getLeft(), super.getCoords().getRight() + EnemyWeaponShot.DELTA)
                : Pair.of(super.getCoords().getLeft() + EnemyWeaponShot.DELTA, super.getCoords().getRight());
        super.setCoords(newCoords);
    }

    private enum ShotAxes {
        X,
        Y
    }

}
