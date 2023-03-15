package it.unibo.isaccoop.model.item;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents a coin in the game.
 * */
public class Coin extends AbstractItem {

    private static final int COIN_UP = 1;

    /**
     *
     * @param coords
     */
    public Coin(final Pair<Double, Double> coords) {
        super(coords);
    }

    /**
     *  Method for interacting with player money.
     *  @param p reference to player.
     * */
    @Override
    public void interact(final PlayerStat p) {
        p.setCoin(p.getCoin() + COIN_UP);
    }

}
