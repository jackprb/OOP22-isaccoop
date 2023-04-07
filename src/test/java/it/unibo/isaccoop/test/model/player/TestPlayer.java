package it.unibo.isaccoop.test.model.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.common.Direction;

/**
 * Class to test the player
 * */
public class TestPlayer {
    final private Player player = new Player(null, null, null);

    /**
     * Testing the player movement in 4 direction.
     * */
    @Test
    void testMovement() {
        final Point2D pos = player.getCoords();
        assertEquals(new Point2D(5.0, 5.0), pos);

        player.update(Direction.UP);
        final Point2D upPos = player.getCoords();
        assertEquals(new Point2D(5.0, 5.0 - player.getSpeed()), upPos);

        player.update(Direction.RIGHT);
        player.update(Direction.RIGHT);
        final Point2D rightPos = player.getCoords();
        assertEquals(new Point2D(5.0 + player.getSpeed() * 2, 5.0 - player.getSpeed()), rightPos);

        player.update(Direction.LEFT);
        final Point2D leftPos = player.getCoords();
        assertEquals(new Point2D(5.0 + player.getSpeed(), 5.0 - player.getSpeed()), leftPos);

        player.update(Direction.DOWN);
        final Point2D downPos = player.getCoords();
        assertEquals(new Point2D(5.0 + player.getSpeed(), 5.0), downPos);
    }
}
