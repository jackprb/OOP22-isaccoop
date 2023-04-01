package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.LevelController;
import it.unibo.isaccoop.model.room.LevelControllerImpl;
import it.unibo.isaccoop.model.room.Room;

/**
 * {@link LevelController} test.
 * */
class LevelControllerTest {

    private static final int NUMBER_OF_LEVELS = 10;
    private static final int MAX_NUMBER_OF_ROOMS = 30;
    private static final int MIN_NUMBER_OF_ROOMS = 6;
    private final LevelController lvlController = new LevelControllerImpl(NUMBER_OF_LEVELS, null);

    @Test 
    void testGetCurrentLevelIndex() {
        // just after the creation of the levelController, the current level must be the first
        assertEquals(this.lvlController.getCurrentLevelIndex(), 0);
    }

    @Test 
    void testGetNumberOfLevels() {
        // check that the level controller has the correct number of levels
        assertEquals(this.lvlController.getNumberOfLevels(), NUMBER_OF_LEVELS);
    }

    @Test
    void testGetNumberOfRoomsOfCurrentLevel() {
        // the level has a random number of rooms N, with 6 <= N < 30
        assertTrue(this.lvlController.getCurrentLevel().getRooms().size() < MAX_NUMBER_OF_ROOMS 
                && this.lvlController.getCurrentLevel().getRooms().size() >= MIN_NUMBER_OF_ROOMS);
    }

    @Test
    void testGetCurrentRoomCoord() {
        // at the beginning, the player is in room (0.0, 0.0)
        assertEquals(this.lvlController.getCurrentRoomCoord(), new Point2D(0.0, 0.0));
    }

    @Test
    void testGetCurrentRoom() {
        // the current room is the room where the player is, i.e., the room where getPlayer() 
        // returns a NON empty optional
        final Room playerRoom = this.lvlController.getCurrentLevel().getRooms().stream()
                .filter(r -> r.getPlayer().isPresent())
                .findFirst().get();

        // so playerRoom must be equal to the room returned by getCurrentRoom()
        assertEquals(playerRoom, this.lvlController.getCurrentRoom());
    }

    @Test
    void testGetPlayer() {
    }

    @Test
    void testIsRoomComplete() {
        // at the beginning, STANDARD and BOSS rooms must be NOT complete
        // (there are enemies to defeat)
        final List<Room> roomsThatMustBeNOTComplete = this.lvlController.getRoomsOfCurrentLevel().stream()
                .filter(r -> r.getRoomType() == RoomType.STANDARD && r.getRoomType() == RoomType.BOSS)
                .collect(Collectors.toUnmodifiableList());
        assertTrue(roomsThatMustBeNOTComplete.stream().allMatch(r -> this.lvlController.isRoomComplete(r)));

        // while other rooms must be complete (there are no enemies to defeat)
        final List<Room> roomsThatMustBeComplete = this.lvlController.getRoomsOfCurrentLevel().stream()
                .filter(r -> r.getRoomType() != RoomType.STANDARD && r.getRoomType() != RoomType.BOSS)
                .collect(Collectors.toUnmodifiableList());
        assertTrue(roomsThatMustBeComplete.stream().allMatch(r -> this.lvlController.isRoomComplete(r)));
    }

    @Test
    void testIsCurrentLevelComplete() {
        // at the beginning, a level cannot be complete
        assertFalse(this.lvlController.isCurrentLevelComplete());
    }

    @Test
    void testAreAllLevelsComplete() {
        // at the beginning, all levels cannot be complete
        assertFalse(this.lvlController.areAllLevelsComplete());
    }

    @Test
    void testGetAccessibleRooms() {
        // since the rooms are placed horizontally, the start room has coordinate (0.0, 0.0)
        // and each room has a coordinate (x, 0.0),
        // at the beginning, the only available room is (1.0)
        final int accessibleRooms = 1;
        assertEquals(this.lvlController.getAccessibleRooms().size(), accessibleRooms);
        assertEquals(this.lvlController.getAccessibleRooms().stream().findFirst().get().getCoords(),
                new Point2D(1.0, 0.0));
    }

    @Test
    void testMoveToRoom() {
        final var room = this.lvlController.getAccessibleRooms().stream().findFirst().get();
        assertTrue(this.lvlController.moveToRoom(room));
    }
}
