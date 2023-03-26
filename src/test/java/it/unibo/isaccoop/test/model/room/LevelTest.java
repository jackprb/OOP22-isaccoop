package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.LevelImpl;
import it.unibo.isaccoop.model.room.Room;
import it.unibo.isaccoop.model.room.RoomFactory;
import it.unibo.isaccoop.model.room.RoomFactoryImpl;

/**
 * RoomFactory test.
 * */
class LevelTest {
    private static final int NUMBER_OF_STANDARD_ROOMS = 10;
    
    private Level level;
    private final RoomFactory roomFactory = new RoomFactoryImpl();
    
    @BeforeEach
    void setUp() {
        this.level = new LevelImpl();    
    }

    @Test 
    void testPutRooms() {
        final List<Room> rooms = new LinkedList<>();
        final List<Room> rooms2 = new LinkedList<>();
        for (final RoomType roomType: RoomType.values()) {
            rooms.add(this.roomFactory.buildRoomOfType(roomType, new Point2D(roomType.ordinal(), 0)));
        }
        for (int i = 0; i < NUMBER_OF_STANDARD_ROOMS; i++) {
            rooms2.add(this.roomFactory.buildStandardRoom(new Point2D(i, 0)));
        }
        this.level.putRooms(rooms); // the level has no rooms -> OK
        
        // the level already has rooms (set in previous line) -> throw exception
        assertThrows(IllegalStateException.class, () -> this.level.putRooms(rooms2)); 
    }

    @Test
    void testGetRooms() {
    }
    
    @Test
    void testIsLevelComplete() {
    }

    @Test
    void testGetStartRoom() {
    }
}
