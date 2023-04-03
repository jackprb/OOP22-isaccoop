package it.unibo.isaccoop.controller.input;
import it.unibo.isaccoop.model.boundingbox.RectBoundingBox;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.room.Room;
/**
 * 
 *
 */
public class PlayerInputComponent implements InputComponent {
    /**
     * 
     */
    @Override
    public void update(final Player player, final Room room) {
        final InputController ctrl = player.getMovementController();

        if (ctrl.isUp() && !player.getBox()
                .isCollidingWithRecPerimeter(player.getMovePreview(Direction.UP), (RectBoundingBox) room.getBox())) {
            player.update(Direction.UP);
        } else if (ctrl.isDown() && !player.getBox()
                .isCollidingWithRecPerimeter(player.getMovePreview(Direction.DOWN), (RectBoundingBox) room.getBox())) {
            player.update(Direction.DOWN);
        } else if (ctrl.isLeft() && !player.getBox()
                .isCollidingWithRecPerimeter(player.getMovePreview(Direction.LEFT), (RectBoundingBox) room.getBox())) {
            player.update(Direction.LEFT);
        } else if (ctrl.isRight() && !player.getBox()
                .isCollidingWithRecPerimeter(player.getMovePreview(Direction.RIGHT), (RectBoundingBox) room.getBox())) {
            player.update(Direction.RIGHT);
        }
    }

}
