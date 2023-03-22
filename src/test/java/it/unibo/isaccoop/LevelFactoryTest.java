package it.unibo.isaccoop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.LevelFactoryImpl;

/**
 * RoomFactory test.
 * */
class LevelFactoryTest {
    private static final int NUMBER_OF_ROOMS = 10;
    private static final int SINGLE_ROOM_COUNT = 1;

    @Test 
    void testCreateLevel() {
        final var levelFactory = new LevelFactoryImpl();
        final var lvl = levelFactory.createLevel(NUMBER_OF_ROOMS);
        final var rooms = lvl.getRooms();
        // check if a just created level has the correct number of rooms
        assertTrue(rooms.size() == NUMBER_OF_ROOMS);
        // and if it is not complete
        assertFalse(lvl.isComplete());

        // in a level, there must be ONLY ONE START, ONE SHOP, ONE TREASURE and ONE BOSS room
        assertTrue(rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.START)
                .count() == SINGLE_ROOM_COUNT);
        assertTrue(rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.SHOP)
                .count() == SINGLE_ROOM_COUNT);
        assertTrue(rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.TREASURE)
                .count() == SINGLE_ROOM_COUNT);
        assertTrue(rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.BOSS)
                .count() == SINGLE_ROOM_COUNT);

        // in a level, the remaining rooms must be STANDARD
        assertTrue(rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.STANDARD)
                .count() == (NUMBER_OF_ROOMS - 4));

        //System.out.println("rooms" + rooms);
        /*rooms.forEach(r -> System.out.println("\n\n\nitems: " + r.getItems() + "\n"
        + "player: " + r.getPlayer() + "\n"
        + "powerups: " + r.getPowerUps() + "\n"
        + "roomAi: " + r.getRoomAI() + "\n"
        + "roomtype: " + r.getRoomType()));*/
    }
}
