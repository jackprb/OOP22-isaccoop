package it.unibo.isaccoop.controller.input;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.player.Player;
/**
 * 
 *
 */
public class PlayerInputComponent implements InputComponent {
    /**
     * 
     */
    @Override
    public void update(final Player player) {
        final InputController ctrl = player.getController();

        if (ctrl.isUp()) {
            player.update(Direction.UP);
        } else if (ctrl.isDown()) {
            player.update(Direction.DOWN);
        } else if (ctrl.isLeft()) {
            player.update(Direction.LEFT);
        } else if (ctrl.isRight()) {
            player.update(Direction.RIGHT);
        }
    }

}
