package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.model.common.Point2D;

/**
 * The class for the bullet movement.
 * */
public class PlayerShot extends PlayerWeaponImpl {

    /**
     * Bullet constructor.
     * @param direction the direction of the "bullet"
     * @param position the position of the "bullet"
     * @param damage the damage of the "bullet"
     * */
    public PlayerShot(final int direction, final Point2D position, final float damage) {
        super(direction, position, damage);
    }

    /**
     * @param distance the distance the bullet travels
     * */
    public void bulletDirection(final float distance) {
        Point2D newPosition;
        switch (super.getDirection()) {
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

}
