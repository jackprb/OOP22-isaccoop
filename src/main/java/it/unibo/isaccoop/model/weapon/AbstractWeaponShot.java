package it.unibo.isaccoop.model.weapon;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public abstract class AbstractWeaponShot extends AbstractMapElement implements WeaponShot {

    private static final Double SPEED = 10.0;
    private final Vector2D shotVector;

    /**
     *  Constructor for {@link EnemyWeaponShot} class.
     *
     *  @param startPosition start {@link EnemyWeaponShot} position as a {@link Pair}
     *  @param direction shot vector
     * */
    public AbstractWeaponShot(final Point2D startPosition, final Vector2D direction) {
        super(startPosition, ElementsRadius.BULLET);
        this.shotVector = direction;
    }

    /**
     * Get Weapon shots speed.
     *
     * @return weapon shots speed
     * */
    protected Double getSpeed() {
        return AbstractWeaponShot.SPEED;
    }

    /**
     * Get Weapon shot vector.
     *
     * @return weapon shot vector
     * */
    protected Vector2D getShotVector() {
        return this.shotVector;
    }

}
