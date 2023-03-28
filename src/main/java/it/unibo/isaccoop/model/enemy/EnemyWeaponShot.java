package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public class EnemyWeaponShot extends AbstractMapElement implements WeaponShot {

    private static final int DELTA = 10;
    private final Vector2D shotVector;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     *  @param direction shot vector
     * */
    public EnemyWeaponShot(final Point2D startPosition, final Vector2D direction) {
        super(startPosition, ElementsRadius.BULLET);
        this.shotVector = direction;
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through a defined vector
     * computed by sub between player position and shot start position.
     * */
    @Override
    public void tickShot() {
        super.setCoords(super.getCoords().sum(this.shotVector.mul(1 / EnemyWeaponShot.DELTA)));
    }

}
