package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.PlayerMovementImpl;

/**
 * Implementation of {@link LevelController}.
 * 
 */
public final class LevelControllerImpl implements LevelController {

    private static final int MAX_NUMBER_OF_ROOMS = 30;
    private static final int MIN_NUMBER_OF_ROOMS = 6;
    private static final int GRIDROWS = 6;
    private static final int GRIDCOLS = 6;

    private final List<Level> lvl = new LinkedList<>();
    private int currentLevelID;
    private Room currentRoom;
    private final PlayerMovementImpl player = new PlayerMovementImpl();

    /**
     * Create a game with the specified number of levels.
     * @param numberOfLevels the number of levels to create
     */
    public LevelControllerImpl(final int numberOfLevels) {
        final LevelFactoryImpl lvlFactory = new LevelFactoryImpl();
        this.currentLevelID = 0;
        for (int i = 0; i < numberOfLevels; i++) {
            final int numberOfRooms = ThreadLocalRandom.current().nextInt(
                    MAX_NUMBER_OF_ROOMS - MIN_NUMBER_OF_ROOMS) + MIN_NUMBER_OF_ROOMS;
            this.lvl.add(lvlFactory.createLevel(numberOfRooms, GRIDROWS, GRIDCOLS));
        }
        this.currentRoom = this.lvl.get(this.currentLevelID).getStartRoom();
    }

    @Override
    public Level getCurrentLevel() {
        return this.lvl.get(currentLevelID);
    }

    @Override
    public List<Room> getRoomsOfCurrentLevel() {
        return this.getCurrentLevel().getRooms();
    }

    @Override
    public Point2D getPlayerRoomCoord() {
        return this.player.getCoords();
    }

    @Override
    public Room getPlayerRoom() {
        return this.currentRoom;
    }

    @Override
    public boolean isRoomComplete(final Room room) {
        return room.isComplete();
    }

    @Override
    public int getNumberOfRooms() {
        return this.getRoomsOfCurrentLevel().size();
    }

    @Override
    public List<Room> getAccessibleRooms() {
        return List.of();
    }

    @Override
    public void moveToRoom(final Room room) {
        this.currentRoom = room;
    }

    @Override
    public boolean isCurrentLevelComplete() {
        if (getCurrentLevel().isComplete()) {
            goToNextLevel();
            return true;
        }
        return false;
    }

    @Override
    public boolean areAllLevelsComplete() {
        return this.lvl.stream().allMatch(l -> l.isComplete());
    }

    private void goToNextLevel() {
        this.currentLevelID++;
    }
}
