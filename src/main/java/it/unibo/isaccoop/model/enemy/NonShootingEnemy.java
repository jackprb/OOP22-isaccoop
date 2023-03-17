package it.unibo.isaccoop.model.enemy;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.AbstractMapElement;

/***/
public final class NonShootingEnemy extends AbstractMapElement implements Enemy {

    private static final int DELTA = 10;

    @Override
    public void onHit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hit(final Pair<Double, Double> playerPosition) {
       //TODO
    }

    @Override
    public void move(final Pair<Double, Double> playerPosition) {
        final double newX = Math.abs(playerPosition.getLeft() - super.getCoords().getLeft()) / NonShootingEnemy.DELTA;
        final double newY = Math.abs(playerPosition.getRight() - super.getCoords().getRight()) / NonShootingEnemy.DELTA;

        super.setCoords(Pair.of(newX, newY));
    }

}
