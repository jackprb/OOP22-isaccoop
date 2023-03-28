package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.room.RoomBuilderUtils;
import it.unibo.isaccoop.model.room.RoomBuilder.Builder;

/**
 * RoomFactory test.
 * */
class RoomBuilderTest {

    private static final int MAX_ROOM_SIZE = 500;
    private static final int MAX_COORD_NUMBER = 20;
    private Builder builder;

    @BeforeEach
    void setUp() {
        this.builder = createBuilder();
    }

    @Test 
    void testPutCoord() {
        final Builder ris = this.builder.putCoord(generateCoord());
        assertEquals(ris, this.builder);
    }

    @Test 
    void testRoomType() {
        for (final var rType: RoomType.values()) {
            final Builder ris = this.builder.roomType(rType);
            assertEquals(ris, this.builder);
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
