package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 *
 * */
public class CoinUp extends PowerUp {
    private static final int COIN_UP = 10;
    private static final int COIN_SUPER_UP = 20;
    /**
     *
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
