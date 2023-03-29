package it.unibo.isaccoop.model.weapon;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public class BaseWeaponShot extends AbstractWeaponShot {

    /**
     * BaseWeaponShot constructor.
     *
     * @param startPosition shot start position
     * @param direction shot direction vector
     * */
    public BaseWeaponShot(final Point2D startPosition, final Vector2D direction) {
        super(startPosition, direction);
    }

    /**
     * Method to increment the position of the shot by {@link EnemyWeaponShot}.DELTA through a defined vector
     * computed by sub between player position and shot start position.
     * */
    @Override
    public void tickShot() {
        super.setCoords(super.getCoords().sum(this.getShotVector().mul(super.getSpeed())));
    }

}
