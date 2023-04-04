package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.graphics.factory.PowerUpGraphicsComponentImpl;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the power up coin.
 * */
public class CoinUp extends PowerUp {

    private static final int COIN_UP = 10;
    private static final int COIN_SUPER_UP = 20;

    /***/
    public CoinUp(GraphicsComponent gr) {
        super(new PowerUpGraphicsComponentImpl().getCoinUpGraphicsComponent(isSuperItem()));
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
