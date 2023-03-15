package it.unibo.isaccoop.model.player;

import org.apache.commons.lang3.tuple.Pair;

/**
 * The class for the bullet movement.
 * */
public class PlayerShot extends PlayerWeaponImpl {

    /**
     * Bullet constructor.
     * @param direction the direction of the "bullet"
     * @param position the position of the "bullet"
     * @param height the height of the "bullet"
     * @param width the width of the "bullet"
     * @param damage the damage of the "bullet"
     * @param speed the speed of the "bullet"
     * */
    public PlayerShot(final int direction, final Pair<Double, Double> position,
                        final float height, final float width, final float damage, final float speed) {
        super(direction, position, height, width, damage, speed);
    }

    /**
     * @param distance the distance the bullet travels
     * */
    public void bulletDirection(final float distance) {
        Pair<Double, Double> newPosition;
        switch (super.getDirection()) {
            /* 0 = up */
            case 0:
                newPosition = Pair.of(super.getPosition().getKey(), super.getPosition().getValue() - distance);
                super.setPosition(newPosition);
            break;
            /* 1 =  right */
            case 1:
                newPosition = Pair.of(super.getPosition().getKey() + distance, super.getPosition().getValue());
                super.setPosition(newPosition);
            break;
            /* 2 = down */
            case 2:
                newPosition = Pair.of(super.getPosition().getKey(), super.getPosition().getValue() + distance);
                super.setPosition(newPosition);
            break;
            /* 3 = left */
            case 3:
                newPosition = Pair.of(super.getPosition().getKey() - distance, super.getPosition().getValue());
                super.setPosition(newPosition);
            break;
            default:
                newPosition = Pair.of(super.getPosition().getKey(), super.getPosition().getValue());
                super.setPosition(newPosition);
        }
    }

}
