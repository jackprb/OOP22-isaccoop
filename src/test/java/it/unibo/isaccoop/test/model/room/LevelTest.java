package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    
    private final RoomFactory roomFactory = new RoomFactoryImpl();
    private final Level level = new LevelImpl();
    private List<Room> rooms = new LinkedList<>();
    private List<Room> rooms2 = new LinkedList<>();

    @Test 
    void testPutRooms() {
        // generate due lists of Room
        for (final RoomType roomType: RoomType.values()) {
            this.rooms.add(this.roomFactory.buildRoomOfType(roomType, new Point2D(roomType.ordinal(), 0)));
        }
        for (int i = 0; i < NUMBER_OF_STANDARD_ROOMS; i++) {
            this.rooms2.add(this.roomFactory.buildStandardRoom(new Point2D(i, 0)));
        }
        this.level.putRooms(rooms); // the level has no rooms -> OK
        
        // the level already has rooms (set in previous line) -> throw exception
        assertThrows(IllegalStateException.class, () -> this.level.putRooms(this.rooms2)); 
    }

    @Test
    void testGetRooms() {
        // the 
        assertEquals(this.level.getRooms(), this.rooms);
    }
    
    @Test
    void testIsLevelComplete() {
        // a just created level cannot be already complete
        assertFalse(this.level.isComplete());
    }

    @Test
    void testGetStartRoom() {
        final Room startRoom = this.level.getRooms().stream()
                .filter(r -> r.getRoomType() == RoomType.START)
                .findFirst().get();
        assertEquals(this.level.getStartRoom(), startRoom);
    }
}
