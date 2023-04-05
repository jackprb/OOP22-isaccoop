package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.graphics.GraphicsComponent;
import it.unibo.isaccoop.graphics.factory.PowerUpGraphicsComponentImpl;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 * Represents the power up speed.
 * */
public class SpeedUp extends PowerUp {

    private static final float SPEED_SUPER_UP = 2;
    private static final float SPEED_UP = 1;

    /***/
    public SpeedUp() {
        super(new PowerUpGraphicsComponentImpl().getSpeedUpGraphicsComponent(false));
    }

    /**
     * Increase the player's speed.
     * @param p reference to player.
     * */
    @Override
    public void interact(final PlayerStat p) {
        if (super.isSuperItem()) {
            p.setSpeed(p.getSpeed() + SPEED_SUPER_UP);
        } else {
            p.setSpeed(p.getSpeed() + SPEED_UP);
        }
    }

    /***/
    @Override
    protected GraphicsComponent updateSuperGraphics(final Boolean isSuper) {
        return new PowerUpGraphicsComponentImpl().getSpeedUpGraphicsComponent(isSuper);
    }
}
