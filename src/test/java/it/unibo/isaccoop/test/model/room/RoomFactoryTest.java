package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.Room;
import it.unibo.isaccoop.model.room.RoomFactory;
import it.unibo.isaccoop.model.room.RoomFactoryImpl;

/**
 * RoomFactory test.
 * */
class RoomFactoryTest {

    private final RoomFactory rFactory = new RoomFactoryImpl();
    private final Point2D COORD = new Point2D(1.0, 0.0);

    @BeforeEach
    void setUp() {
    }

    @Test 
    void testBuildBossRoom() {
        final Room bossRoom = this.rFactory.buildBossRoom(this.COORD);

        // check if all fields are set properly
        assertEquals(bossRoom.getCoords(), this.COORD);
        assertTrue(bossRoom.getEnemies().isPresent());
        assertTrue(bossRoom.getItems().isEmpty());
        assertTrue(bossRoom.getPlayer().isEmpty());
        assertTrue(bossRoom.getRoomAI().isPresent());
        assertTrue(bossRoom.getPowerUps().isEmpty());
        assertEquals(bossRoom.getRoomType(), RoomType.BOSS);
        assertFalse(bossRoom.isComplete());
    }

    @Test
    void testBuildStandardRoom() {
        final Room standardRoom = this.rFactory.buildStandardRoom(this.COORD);

        // check if all fields are set properly
        assertEquals(standardRoom.getCoords(), this.COORD);
        assertTrue(standardRoom.getEnemies().isPresent());
        assertTrue(standardRoom.getItems().isEmpty());
        assertTrue(standardRoom.getPlayer().isEmpty());
        assertTrue(standardRoom.getRoomAI().isPresent());
        assertTrue(standardRoom.getPowerUps().isEmpty());
        assertEquals(standardRoom.getRoomType(), RoomType.BOSS);
        assertFalse(standardRoom.isComplete());
    }
    
    @Test
    void testBuild() {
        
    }
}
