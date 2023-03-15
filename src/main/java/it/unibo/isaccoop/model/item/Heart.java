package it.unibo.isaccoop.model.item;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents a heart in the game.
 * */
public class Heart extends AbstractItem {
    /**
     *
     * @param coords
     */
    public Heart(Pair<Double, Double> coords) {
        super(coords);
    }

    private static final int HEART_UP = 1;

    /**
     *  Method for interacting with player heart.
     *  @param p reference to player.
     * */
    @Override
    public void interact(final PlayerStat p) {
        if (p.getHeart() < p.getMaxHeart()) {
            p.setHeart(p.getHeart() + HEART_UP);
        }
    }

}
