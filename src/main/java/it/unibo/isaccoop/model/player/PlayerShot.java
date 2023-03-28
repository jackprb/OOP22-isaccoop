package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Vector2D;
import it.unibo.isaccoop.model.enemy.WeaponShot;

/**
 * The class for the bullet movement.
 * */
public class PlayerShot extends AbstractMapElement implements WeaponShot{

    private static final int DELTA = 10;
    private final Vector2D shotVector;

    /**
     * Bullet constructor.
     * @param direction the direction of the "bullet"
     * @param position the position of the "bullet"
     * @param damage the damage of the "bullet"
     * */
    public PlayerShot(final Vector2D direction, final Point2D startPosition) {
        super(startPosition, ElementsRadius.BULLET);
        this.shotVector = direction;
    }

    /**
     * @param distance the distance the bullet travels
     * @param direction the direction in which the bullet is fired
     * */
    public void bulletDirection(final int direction, final float distance) {
        Point2D newPosition;
        switch (direction) {
            /* 0 = up */
            case 0:
                newPosition = new Point2D(super.getCoords().getX(), super.getCoords().getY() - distance);
                super.setCoords(newPosition);
            break;
            /* 1 =  right */
            case 1:
                newPosition = new Point2D(super.getCoords().getX() + distance, super.getCoords().getY());
                super.setCoords(newPosition);
            break;
            /* 2 = down */
            case 2:
                newPosition = new Point2D(super.getCoords().getX(), super.getCoords().getY() + distance);
                super.setCoords(newPosition);
            break;
            /* 3 = left */
            case 3:
                newPosition = new Point2D(super.getCoords().getX() - distance, super.getCoords().getY());
                super.setCoords(newPosition);
            break;
            default:
                newPosition = new Point2D(super.getCoords().getX(), super.getCoords().getY());
                super.setCoords(newPosition);
        }
    }

    /***/
    @Override
    public void tickShot() {
        super.setCoords(super.getCoords().sum(this.shotVector.mul(1 / PlayerShot.DELTA)));
    }

}
