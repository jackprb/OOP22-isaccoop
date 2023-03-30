package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.LevelFactoryImpl;
import it.unibo.isaccoop.model.room.LevelImpl;
import it.unibo.isaccoop.model.room.Room;
import it.unibo.isaccoop.model.room.RoomFactory;
import it.unibo.isaccoop.model.room.RoomFactoryImpl;

/**
 * Level test.
 * */
class LevelTest {
    private static final int NUMBER_OF_ROOMS = 10;

    // variables for local level
    private final RoomFactory roomFactory = new RoomFactoryImpl(NUMBER_OF_ROOMS);
    private final Level localLevel = new LevelImpl();
    private final List<Room> otherRoomList = new LinkedList<>();

    // variable to store data generate from LevelFactoryImpl
    private List<Room> roomListFromFactory = new LinkedList<>();

    @BeforeEach
    void setUp() {
        // generate a complete level using LevelFactoryImpl
        final Level lvl = new LevelFactoryImpl().createLevel();
        // get the rooms of that level
        this.roomListFromFactory = lvl.getRooms();
        // put the rooms in the localLevel
        this.localLevel.putRooms(this.roomListFromFactory); // the level has no rooms -> OK
    }

    @Test 
    void testPutRooms() {
        // generate another List<Room>
        for (final RoomType roomType: RoomType.values()) {
            this.otherRoomList.add(this.roomFactory.buildRoomInProperOrder(new Point2D(roomType.ordinal(), 0)));
        }

        // the level already has rooms (set in method setUp()) -> throw exception
        assertThrows(IllegalStateException.class, () -> this.localLevel.putRooms(this.otherRoomList)); 

        // the localLevel must have the correct number of rooms
        assertEquals(this.localLevel.getRooms().size(), NUMBER_OF_ROOMS);
    }

    @Test
    void testGetRooms() {
        // the List<Room> returned from localLevel is the same in roomListFromFactory
        // so, those lists must be equal
        assertEquals(this.localLevel.getRooms(), this.roomListFromFactory);
    }

    @Test
    void testIsLevelComplete() {
        // a just created level cannot be already complete
        assertFalse(this.localLevel.isComplete());
    }

    @Test
    void testGetStartRoom() {
        final Room startRoom = this.localLevel.getRooms().stream()
                .filter(r -> r.getRoomType() == RoomType.START)
                .findFirst().get();
        assertEquals(this.localLevel.getStartRoom().getRoomType(), startRoom.getRoomType());
    }
}
