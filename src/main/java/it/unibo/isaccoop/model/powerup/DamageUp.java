package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the power up damage.
 * */
public class DamageUp extends PowerUp {

    private static final float DAMAGE_SUPER_UP = 1;
    private static final float DAMAGE_UP = 2;
    /**
     *  Increase the player's damage.
     *  @param p reference to player.
     * */
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setDamage(p.getDamage() + DAMAGE_SUPER_UP);
            this.setPrice(10);
        } else {
            p.setDamage(p.getDamage() + DAMAGE_UP);
            this.setPrice(5);
        }

    }

}
