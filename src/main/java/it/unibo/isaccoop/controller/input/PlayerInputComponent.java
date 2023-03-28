package it.unibo.isaccoop.controller.input;
import it.unibo.isaccoop.model.player.Player;
/**
 * 
 *
 */
public class PlayerInputComponent extends AbstractInputComponent {
    /**
     * 
     */
    @Override
    public void update(final Player player) {
        final InputController ctrl = player.getController();

        if (ctrl.isUp()) {
            player.update(0);
        } else if (ctrl.isDown()) {
            player.update(2);
        } else if (ctrl.isLeft()) {
            player.update(3);
        } else if (ctrl.isRight()) {
            player.update(1);
        }
    }

}
