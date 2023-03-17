package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;

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
    public EnemyWeaponShot(final Point2D startPosition, final Point2D playerPosition) {
        super(startPosition);
        this.axis = Math.abs(playerPosition.getX() - startPosition.getX())
                <= Math.abs(playerPosition.getY() - startPosition.getY())
                ? ShotAxes.X
                : ShotAxes.Y;
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through random axis.
     * */
    public void tickShot() {
        final Point2D newCoords = this.axis.equals(ShotAxes.Y)
                ? new Point2D(super.getCoords().getX(), super.getCoords().getY() + EnemyWeaponShot.DELTA)
                : new Point2D(super.getCoords().getX() + EnemyWeaponShot.DELTA, super.getCoords().getY());
        super.setCoords(newCoords);
    }

    private enum ShotAxes {
        X,
        Y
    }

}
