package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public class TearsUp extends PowerUp {

    private static final int TEARS_SUPER_UP = 2;
    private static final int TEARS_UP = 1;

    /***/
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setTears(p.getTears() + TEARS_SUPER_UP);
        } else {
            p.setTears(p.getTears() + TEARS_UP);
        }
    }

}
