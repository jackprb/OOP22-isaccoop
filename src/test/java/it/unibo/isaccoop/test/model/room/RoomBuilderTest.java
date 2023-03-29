package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.room.RoomBuilderUtils;
import it.unibo.isaccoop.model.room.RoomBuilder.Builder;

/**
 * RoomBuilder test.
 */
class RoomBuilderTest {

    private static final int MAX_ROOM_SIZE = 500;
    private static final int MAX_COORD_NUMBER = 20;

    @Test 
    void testPutCoord() {
        final Builder emptyBuilder = createBuilder();
        final Builder ris = emptyBuilder.putCoord(generateCoord());
        assertEquals(ris, emptyBuilder);
    }

    @Test 
    void testRoomType() {
        for (final var rType: RoomType.values()) {
            final Builder emptyBuilder = createBuilder();
            final Builder ris = emptyBuilder.roomType(rType);
            assertEquals(ris, emptyBuilder);
        }
    }

    @Test 
    void testPutItems() {
        for (final var rType: RoomType.values()) {
            final RoomBuilderUtils utils = new RoomBuilderUtils(rType);
            final Builder localBuilder = new Builder(MAX_ROOM_SIZE, MAX_COORD_NUMBER)
                    .putCoord(generateCoord())
                    .roomType(rType);
            if (utils.canRoomHaveItems()) {
                assertEquals(localBuilder.putItems(), localBuilder);
            } else {
                assertThrows(IllegalStateException.class, () -> localBuilder.putItems());
            }
        }
    }

    @Test 
    void testPutEnemies() {
        for (final var rType: RoomType.values()) {
            final RoomBuilderUtils utils = new RoomBuilderUtils(rType);
            final Builder localBuilder = new Builder(MAX_ROOM_SIZE, MAX_COORD_NUMBER)
                    .putCoord(generateCoord())
                    .roomType(rType);
            if (utils.canRoomHaveEnemies()) {
                assertEquals(localBuilder.putEnemies(), localBuilder);
            } else {
                assertThrows(IllegalStateException.class, () -> localBuilder.putEnemies());
            }
        }
    }

    @Test 
    void testPutPlayer() {
        for (final var rType: RoomType.values()) {
            final RoomBuilderUtils utils = new RoomBuilderUtils(rType);
            final Builder localBuilder = new Builder(MAX_ROOM_SIZE, MAX_COORD_NUMBER)
                    .putCoord(generateCoord())
                    .roomType(rType);
            final Player player = new Player();
            if (utils.canRoomHavePlayer()) {
                assertEquals(localBuilder.putPlayer(player), localBuilder);
            } else {
                assertThrows(IllegalStateException.class, () -> localBuilder.putPlayer(player));
            }
        }
    }

    @Test 
    void testPutPowerUps() {
        for (final var rType: RoomType.values()) {
            final RoomBuilderUtils utils = new RoomBuilderUtils(rType);
            final Builder localBuilder = new Builder(MAX_ROOM_SIZE, MAX_COORD_NUMBER)
                    .putCoord(generateCoord())
                    .roomType(rType);
            if (utils.canRoomHavePowerUps()) {
                assertEquals(localBuilder.putPowerUps(), localBuilder);
            } else {
                assertThrows(IllegalStateException.class, () -> localBuilder.putPowerUps());
            }
        }
    }

    @Test 
    void testBuild() {
        for (final var rType: RoomType.values()) {
            final Builder localBuilder = new Builder(MAX_ROOM_SIZE, MAX_COORD_NUMBER)
                    .putCoord(generateCoord())
                    .roomType(rType);

            // build() at this point will throw an exception because each room requires
            // to set at least another field with its dedicated method
            assertThrows(IllegalStateException.class, () -> localBuilder.build());

            // previous tests check if a room is created correctly, using the correct methods
            // so such tests are not repeated here
        }
    }

    /**
     * Utility method to create a new builder.
     * @return a new builder
     */
    private Builder createBuilder() {
        return new Builder(ThreadLocalRandom.current().nextInt(MAX_ROOM_SIZE), 
                ThreadLocalRandom.current().nextInt(MAX_ROOM_SIZE));
    }

    /**
     * Utility method to generate a new random {@link Point2D}.
     * @return a new Point2D
     */
    private Point2D generateCoord() {
        return new Point2D(ThreadLocalRandom.current().nextInt(MAX_COORD_NUMBER), 
                ThreadLocalRandom.current().nextInt(MAX_COORD_NUMBER));
    }
}
