package it.unibo.isaccoop.model.weapon;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.WeaponShot;

public abstract class AbstractWeaponShot extends AbstractMapElement implements WeaponShot {

    private static final Double SPEED = 10.0;
    protected final Vector2D shotVector;

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

    protected Double getSpeed() {
        return AbstractWeaponShot.SPEED;
    }

}
