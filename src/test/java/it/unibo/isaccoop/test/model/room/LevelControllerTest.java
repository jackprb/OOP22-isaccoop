package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.core.GameEngineImpl;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.room.LevelController;
import it.unibo.isaccoop.model.room.LevelControllerImpl;
import it.unibo.isaccoop.model.room.Room;

/**
 * {@link LevelController} test.
 * This test is meant to check if the {@link LevelController} methods work properly.
 */
class LevelControllerTest {

    private static final int NUMBER_OF_LEVELS = 10;
    private static final int MAX_NUMBER_OF_ROOMS = 30;
    private static final int MIN_NUMBER_OF_ROOMS = 6;
    private final LevelController lvlController = new LevelControllerImpl(NUMBER_OF_LEVELS, new GameEngineImpl());

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
    void testMoveToRoom() {
        // this test checks if the player moves correctly from a room to another, NOT using
        // the dedicated methods getPreviousRoom() and getNextRoom(), to ensure that
        // this method works independently from them

        // at the beginning, the player is in START room (room coordinate: (0.0, 0.0))
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(0.0, 0.0));

        // since the level is made up of rooms placed horizontally, the next accessible room has 
        // coordinate (1.0, 0.0), reachable going RIGHT from current room
        final var nextRoom1 = this.lvlController.getAccessibleRooms().entrySet().stream()
                .filter(e -> e.getKey() == Direction.RIGHT).findFirst().get().getValue();
        assertEquals(nextRoom1.getCoords(), new Point2D(1.0, 0.0));

        // if moveToRoom() returns true, means that the player moved to given room successfully
        assertTrue(this.lvlController.moveToRoom(nextRoom1));

        // nextRoom can be a SHOP, STANDARD or TREASURE room, but NOT a START or BOSS room
        assertNotEquals(nextRoom1.getRoomType(), RoomType.START);
        assertNotEquals(nextRoom1.getRoomType(), RoomType.BOSS);

        // now player is in room (1.0, 0.0) (previously known as nextRoom1)
        // so find the next room available going RIGHT, that must have coordinate (2.0, 0.0)
        // and move to it, if such room is already complete (a NON STANDARD room)
        final var nextRoom2 = this.lvlController.getAccessibleRooms().entrySet().stream()
                .filter(e -> e.getKey() == Direction.RIGHT).findFirst().get().getValue();
        assertEquals(nextRoom2.getCoords(), new Point2D(2.0, 0.0));

        // if current room (known as nextRoom1) is complete, player can move to nextRoom2
        if (this.lvlController.getCurrentRoom().isComplete()) {
            assertTrue(this.lvlController.moveToRoom(nextRoom2));
        } else {
            assertFalse(this.lvlController.moveToRoom(nextRoom2));
        }

        // now player is in room (2.0, 0.0) (previously known as nextRoom2)
        // so find the next room available going RIGHT, that must have coordinate (3.0, 0.0)
        // and move to it, if such room is already complete (a NON STANDARD room)
        final var nextRoom3 = this.lvlController.getAccessibleRooms().entrySet().stream()
                .filter(e -> e.getKey() == Direction.RIGHT).findFirst().get().getValue();
        assertEquals(nextRoom3.getCoords(), new Point2D(3.0, 0.0));

        // if current room (known as nextRoom1) is complete, player can move to nextRoom2
        if (this.lvlController.getCurrentRoom().isComplete()) {
            assertTrue(this.lvlController.moveToRoom(nextRoom3));
        } else {
            assertFalse(this.lvlController.moveToRoom(nextRoom3));
        }
    }

    @Test 
    void testGetPreviousRoom() {
        // the player is in room (0.0, 0.0), so there is not a previous room
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(0.0, 0.0));
        assertEquals(this.lvlController.getPreviousRoom(), Optional.empty());
    }

    @Test 
    void testGetNextRoom() {
        // the player is room (0.0, 0.0), so the next room is room with coord (1.0, 0.0)
        final var expectedRoom = Optional.of(this.lvlController.getAccessibleRooms().entrySet().stream()
                .filter(e -> e.getKey() == Direction.RIGHT).findFirst().get().getValue());
        assertEquals(this.lvlController.getNextRoom(), expectedRoom);
    }

    @Test
    void testMoveUsingGetPreviousAndGetNextRoom() {
        // execute again this test to check that the player is actually in room (0.0, 0.0)
        testGetPreviousRoom();

        // if player moves to room (1.0, 0.0)
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getNextRoom().get()));
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(1.0, 0.0));

        // and then to room (2.0, 0.0)
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getNextRoom().get()));
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(2.0, 0.0));

        // now the player can move back to room (1.0, 0.0)
        assertEquals(this.lvlController.getPreviousRoom().get().getCoords(), new Point2D(1.0, 0.0));
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getPreviousRoom().get()));

        // and then to room (0.0, 0.0)
        assertEquals(this.lvlController.getPreviousRoom().get().getCoords(), new Point2D(0.0, 0.0));
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getPreviousRoom().get()));
    }

    @Test
    void testMisuseOfMoveToRoom() {
        // method moveToRoom() allows the player to move only from near rooms 
        // in other words, if the player wants to move from room (2.0, 0.0) to (0.0, 0.0)
        // they must move first to room (1.0, 0.0) and finally in (0.0, 0.0)
        // (the same if the player wants to move from (1.0, 0.0) to (3.0, 0.0))

        // execute again this test to check that the player is actually in room (0.0, 0.0)
        testGetPreviousRoom();

        // player moves to room (1.0, 0.0) using getNextRoom()
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getNextRoom().get()));
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(1.0, 0.0));
        // then moves to room (2.0, 0.0) 
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getNextRoom().get()));
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(2.0, 0.0));
        // and then to (3.0, 0.0)
        assertTrue(this.lvlController.moveToRoom(this.lvlController.getNextRoom().get()));
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(3.0, 0.0));

        // current room is (3.0, 0.0)
        final Room room3 = this.lvlController.getCurrentRoom();
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), new Point2D(3.0, 0.0));
        // get room (1.0, 0.0)
        final Room room1 = this.lvlController.getRoomsOfCurrentLevel().stream()
                .filter(r -> r.getCoords().equals(new Point2D(1.0, 0.0))).findFirst().get();
        // get room (0.0, 0.0)
        final Room room0 = this.lvlController.getRoomsOfCurrentLevel().stream()
                .filter(r -> r.getCoords().equals(new Point2D(0.0, 0.0))).findFirst().get();

        // the player cannot move directly from room (3.0, 0.0) to (1.0, 0.0)
        assertFalse(this.lvlController.moveToRoom(room1));
        // player is still in room (3.0, 0.0)
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), room3.getCoords());

        // and cannot move directly from room (3.0, 0.0) to (0.0, 0.0)
        assertFalse(this.lvlController.moveToRoom(room0));
        // again, player is still in room (3.0, 0.0)
        assertEquals(this.lvlController.getCurrentRoom().getCoords(), room3.getCoords());
    }
}
