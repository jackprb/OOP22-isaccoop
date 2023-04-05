package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.graphics.factory.PowerUpGraphicsComponentImpl;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the power up range.
 * */
public class RangeUp extends PowerUp {

    private static final float RANGE_SUPER_UP = 2;
    private static final float RANGE_UP = 1;

    /***/
    public RangeUp() {
        super(new PowerUpGraphicsComponentImpl().getRangeUpGraphicsComponent(isSuperItem()));
    }

    /**
     * Increase the player's range.
     * @param p reference to player.
     * */
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setRange(p.getRange() + RANGE_SUPER_UP);
        } else {
            p.setRange(p.getRange() + RANGE_UP);
        }
    }

}
