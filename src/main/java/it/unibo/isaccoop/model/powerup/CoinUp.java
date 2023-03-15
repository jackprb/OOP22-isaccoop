package it.unibo.isaccoop.model.powerup;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the power up coin.
 * */
public class CoinUp extends PowerUp {

    private static final int COIN_UP = 10;
    private static final int COIN_SUPER_UP = 20;
    /**
     *
     * @param coords
     */
    public CoinUp(final Pair<Double, Double> coords) {
        super(coords);
    }
    /**
     *  Increase the player's coins.
     *  @param p reference to player.
     * */
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setCoin(p.getCoin() + COIN_SUPER_UP);
        } else {
            p.setCoin(p.getCoin() + COIN_UP);
        }
    }

}
