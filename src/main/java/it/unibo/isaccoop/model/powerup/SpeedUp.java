package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 *
 * */
public class SpeedUp extends PowerUp {

    private static final float SPEED_SUPER_UP = 2;
    private static final float SPEED_UP = 1;

    /***/
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setSpeed(p.getSpeed() + SPEED_SUPER_UP);
        } else {
            p.setSpeed(p.getSpeed() + SPEED_UP);
        }
    }

}
