package it.unibo.isaccoop.controller.input;
import it.unibo.isaccoop.model.player.Player;
/**
 * 
 *
 */
public class PlayerInputComponent extends AbstractInputComponent{
    /**
     * 
     * @param player
     */
    public PlayerInputComponent(Player player) {
        super(player);
    }

    /**
     * 
     */
    @Override
    public void update() {
        InputController ctrl = getPlayer().getController();

        if(ctrl.isUp()) {
            this.getPlayer().update(0);
        } else if (ctrl.isDown()) {
            this.getPlayer().update(2);
        } else if (ctrl.isLeft()) {
            this.getPlayer().update(3);
        } else if (ctrl.isRight()) {
            this.getPlayer().update(1);
        }
    }

}
