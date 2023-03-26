package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

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
    private Point2D coord;
    private static final int MAX_COORD_VALUE = 30; // just for testing purposes 

    @BeforeEach
    void setUp() {
        final Random rnd = new Random();
        this.coord = new Point2D(rnd.nextInt(MAX_COORD_VALUE), rnd.nextInt(MAX_COORD_VALUE));
    }

    @Test 
    void testBuildBossRoom() {
        final Room bossRoom = this.rFactory.buildBossRoom(this.coord);

        // check if all fields are set properly
        assertEquals(bossRoom.getCoords(), this.coord);
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
        final Room standardRoom = this.rFactory.buildStandardRoom(this.coord);

        // check if all fields are set properly
        assertEquals(standardRoom.getCoords(), this.coord);
        assertTrue(standardRoom.getEnemies().isPresent());
        assertTrue(standardRoom.getItems().isPresent());
        assertTrue(standardRoom.getPlayer().isEmpty());
        assertTrue(standardRoom.getRoomAI().isPresent());
        assertTrue(standardRoom.getPowerUps().isEmpty());
        assertEquals(standardRoom.getRoomType(), RoomType.STANDARD);
        assertFalse(standardRoom.isComplete());
    }

    @Test
    void testBuildShopRoom() {
        final Room shopRoom = this.rFactory.buildShopRoom(this.coord);

        // check if all fields are set properly
        assertEquals(shopRoom.getCoords(), this.coord);
        assertTrue(shopRoom.getEnemies().isEmpty());
        assertTrue(shopRoom.getItems().isEmpty());
        assertTrue(shopRoom.getPlayer().isEmpty());
        assertTrue(shopRoom.getRoomAI().isEmpty());
        assertTrue(shopRoom.getPowerUps().isPresent());
        assertEquals(shopRoom.getRoomType(), RoomType.SHOP);
        assertTrue(shopRoom.isComplete());
    }

    @Test
    void testBuild() {
        
    }
}
