package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/***/
public class DamageUp extends PowerUp {
    private static final float DAMAGE_SUPER_UP = 1;
    private static final float DAMAGE_UP = 2;

    /***/
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setDamage(p.getDamage() + DAMAGE_SUPER_UP);
        } else {
            p.setDamage(p.getDamage() + DAMAGE_UP);
        }

    }

}
