package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 *
 * */
public class HealthUp extends PowerUp {
   private static final int HEALTH_SUPER_UP = 2;
   private static final int HEALTH_UP = 1;

   /**
    *
    * */
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setMaxHeart(p.getMaxHeart() + HEALTH_SUPER_UP);
        } else {
            p.setMaxHeart(p.getMaxHeart() + HEALTH_UP);
        }
    }

}
