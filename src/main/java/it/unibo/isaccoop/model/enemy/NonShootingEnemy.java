package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;
import it.unibo.isaccoop.model.common.Point2D;

/***/
public final class NonShootingEnemy extends AbstractMapElement implements Enemy {

    private static final int DELTA = 10;

    @Override
    public void onHit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hit(final Point2D playerPosition) {
       //TODO
    }

    @Override
    public void move(final Point2D playerPosition) {
        final double newX = Math.abs(playerPosition.getX() - super.getCoords().getX()) / NonShootingEnemy.DELTA;
        final double newY = Math.abs(playerPosition.getY() - super.getCoords().getY()) / NonShootingEnemy.DELTA;

        super.setCoords(new Point2D(newX, newY));
    }

}
