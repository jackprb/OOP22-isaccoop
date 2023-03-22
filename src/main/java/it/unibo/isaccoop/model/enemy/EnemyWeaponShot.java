package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public class EnemyWeaponShot extends AbstractMapElement {

    private static final int DELTA = 10;
    private final Vector2D shotVector;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     *  @param playerPosition player position in order to set the shot vector
     * */
    public EnemyWeaponShot(final Point2D startPosition, final Point2D playerPosition) {
        super(startPosition, ElementsRadius.BULLET);
        this.shotVector = playerPosition.sub(startPosition);
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through a defined vector
     * computed by sub between player position and shot start position.
     * */
    public void tickShot() {
        super.setCoords(super.getCoords().sum(this.shotVector.mul(1 / EnemyWeaponShot.DELTA)));
    }

}
