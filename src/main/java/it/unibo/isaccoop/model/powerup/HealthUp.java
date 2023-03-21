package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the power up health.
 * */
public class HealthUp extends PowerUp {

   private static final int HEALTH_SUPER_UP = 2;
   private static final int HEALTH_UP = 1;

   /**
    *   Increase the player's health.
    *   @param p reference to player.
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