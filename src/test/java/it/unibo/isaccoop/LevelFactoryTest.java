package it.unibo.isaccoop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.LevelFactory;
import it.unibo.isaccoop.model.room.LevelFactoryImpl;
import it.unibo.isaccoop.model.room.Room;

/**
 * RoomFactory test.
 * */
class LevelFactoryTest {
    private static final int NUMBER_OF_ROOMS = 10;
    private static final int SINGLE_ROOM_COUNT = 1;
    private static final int NON_STANDARD_ROOM_COUNT = 4;
    private static final int POWERUP_COUNT_IN_SHOP = 3;
    private static final int POWERUP_COUNT_IN_TREASURE_ROOM = 1;

    private LevelFactory lvlFactory = new LevelFactoryImpl();
    private Level lvl;
    private List<Room> rooms;

    @BeforeEach
    void setUp() throws Exception {
        this.lvl = this.lvlFactory.createLevel(NUMBER_OF_ROOMS);
        this.rooms = lvl.getRooms();
    }

    @Test 
    void testRoomCreation() {
        // check if a just created level has the correct number of rooms
        assertTrue(this.rooms.size() == NUMBER_OF_ROOMS);
        // and if it is not complete
        assertFalse(this.lvl.isComplete());
    }

    @Test
    void testRoomTypeCount() {
        // in a level, there must be ONLY ONE START, ONE SHOP, ONE TREASURE and ONE BOSS room
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.START)
                .count() == SINGLE_ROOM_COUNT);
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.SHOP)
                .count() == SINGLE_ROOM_COUNT);
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.TREASURE)
                .count() == SINGLE_ROOM_COUNT);
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.BOSS)
                .count() == SINGLE_ROOM_COUNT);

        // in a level, the remaining rooms must be STANDARD
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.STANDARD)
                .count() == (NUMBER_OF_ROOMS - NON_STANDARD_ROOM_COUNT));

        //System.out.println("rooms" + rooms);
        /*rooms.forEach(r -> System.out.println("\n\n\nitems: " + r.getItems() + "\n"
        + "player: " + r.getPlayer() + "\n"
        + "powerups: " + r.getPowerUps() + "\n"
        + "roomAi: " + r.getRoomAI() + "\n"
        + "roomtype: " + r.getRoomType()));*/
    }

    @Test 
    void testPlayerLocationInLevel() {
        // when a level is created, the player must be in the START room ONLY

        // considering only the START rooms (there will be only one), and in that one
        // where will be the player
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.START)
                .allMatch(r -> r.getPlayer().isPresent()));
        // considering the other rooms, the player will not be in any of them
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() != RoomType.START)
                .allMatch(r -> r.getPlayer().isEmpty()));
    }

    @Test
    void testPowerUpInTreasureRoom() {
        // when a level is created, there must be powerups only in TREASURE and SHOP rooms
        // in the treasure room there will be exactly one powerup
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.TREASURE)
                .allMatch(r -> r.getPowerUps().isPresent()));
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.TREASURE)
                .allMatch(r -> r.getPowerUps().get().size() == POWERUP_COUNT_IN_TREASURE_ROOM));
    }

    @Test
    void testPowerUpInShopRoom() {
        // when a level is created, there must be powerups only in TREASURE and SHOP rooms
        // in the shop room there will be exaclty 3 powerups
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.SHOP)
                .allMatch(r -> r.getPowerUps().isPresent()));
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomType() == RoomType.SHOP)
                .allMatch(r -> r.getPowerUps().get().size() == POWERUP_COUNT_IN_SHOP));
    }

    @Test
    void testPowerUpInOtherRooms() {
        // when a level is created, there must be powerups only in TREASURE and SHOP rooms
        // so, in the other rooms there must be NO items
        assertTrue(this.rooms.stream()
                .filter(r -> !checkConditionForPowerUp(r))
                .allMatch(r -> r.getPowerUps().isEmpty()));
    }

    @Test
    void testItemsInRooms() {
        // when a level is created, there must be at least one item ONLY in STANDARD rooms
        // only STANDARD rooms must have an item list 
        assertTrue(this.rooms.stream()
                .filter(r -> r.getItems().isPresent())
                .allMatch(r -> r.getRoomType() == RoomType.STANDARD));
        // all other room types must NOT have an item list
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomAI().isEmpty())
                .allMatch(r -> r.getRoomType() != RoomType.STANDARD));
    }

    @Test
    void testRoomAiInRooms() {
        // when a level is created, there must be an AIenemy only in BOSS and STANDARD rooms
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomAI().isPresent())
                .allMatch(r -> checkConditionForAiRoom(r)));
        // all other room types must NOT have an AIenemy
        assertTrue(this.rooms.stream()
                .filter(r -> r.getRoomAI().isEmpty())
                .allMatch(r -> !checkConditionForAiRoom(r)));
    }

    @Test
    void testRoomStatus() {
        // when a level is created, BOSS and STANDARD must be NOT complete
        // (the player must defeat all enemies to complete a room)
        assertTrue(this.rooms.stream()
                .filter(r -> checkConditionForAiRoom(r))
                .allMatch(r -> !r.isComplete()));
        // the other rooms are already complete, because there are no enemies
        assertTrue(this.rooms.stream()
                .filter(r -> !checkConditionForAiRoom(r))
                .allMatch(r -> r.isComplete()));
    }

    @Test
    void testRoomCoord() {
        // the rooms are placed in a horizontal line, so each room has a coordinate (x, 0)
        assertTrue(this.rooms.stream()
                .allMatch(r -> r.getCoords().getX() >= 0 
                    && r.getCoords().getY() == 0));
    }

    /**
     * Check if the current room needs the AiEnemy object.
     * @param room the considered room
     * @return true if the room needs the AiEnemy object, false otherwise
     */
    private boolean checkConditionForAiRoom(final Room room) {
        return room.getRoomType() == RoomType.STANDARD || room.getRoomType() == RoomType.BOSS;
    }

    /**
     * Check if the current room needs powerups.
     * @param room the considered room
     * @return true if the room needs at least one powerup object, false otherwise
     */
    private boolean checkConditionForPowerUp(final Room room) {
        return room.getRoomType() == RoomType.SHOP || room.getRoomType() == RoomType.TREASURE;
    }
}
