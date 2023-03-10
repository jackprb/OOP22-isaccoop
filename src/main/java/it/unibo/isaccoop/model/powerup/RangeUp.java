package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public class RangeUp extends PowerUp {
    private static final float RANGE_SUPER_UP = 2;
    private static final float RANGE_UP = 1;

    /***/
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setRange(p.getRange() + RANGE_SUPER_UP);
        } else {
            p.setRange(p.getRange() + RANGE_UP);
        }
    }

}
