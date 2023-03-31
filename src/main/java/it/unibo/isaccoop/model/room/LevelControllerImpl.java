package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link LevelController}.
 */
public final class LevelControllerImpl implements LevelController {

    private final List<Level> lvl = new LinkedList<>();
    private int currentLevelID;
    private Room currentRoom;

    /**
     * Create a game with the specified number of levels.
     * @param numberOfLevels the number of levels to create
     * @param inputController the inputController to be attached to this level
     */
    public LevelControllerImpl(final int numberOfLevels, final InputController inputController) {
        //final InputController inController = inputController;
        final LevelFactoryImpl lvlFactory = new LevelFactoryImpl();
        this.currentLevelID = 0;
        Stream.iterate(0, i -> i + 1)
            .limit(numberOfLevels)
            .forEach(r -> this.lvl.add(lvlFactory.createLevel()));
        this.currentRoom = this.lvl.get(this.currentLevelID).getStartRoom();
    }

    @Override
    public Level getCurrentLevel() {
        return this.lvl.get(currentLevelID);
    }

    @Override
    public List<Room> getRoomsOfCurrentLevel() {
        return List.copyOf(getCurrentLevel().getRooms());
    }

    @Override
    public int getNumberOfRooms() {
        return getRoomsOfCurrentLevel().size();
    }

    @Override
    public Point2D getPlayerRoomCoord() {
        return getPlayerRoom().getCoords();
    }

    @Override
    public Room getPlayerRoom() {
        return this.currentRoom;
    }

    @Override
    public Player getPlayer() {
        return getCurrentLevel().getRooms().stream()
                .filter(r -> r.getPlayer().isPresent())
                .findFirst().get().getPlayer().get();
    }

    @Override
    public boolean isRoomComplete(final Room room) {
        return room.isComplete();
    }


    @Override
    public List<Room> getAccessibleRooms() {
        return List.copyOf(getAvailableRooms());
    }

    @Override
    public void moveToRoom(final Room room) {
        if (isRoomComplete(room)) {
            this.currentRoom = room;
            // removes player from current room
            // and moves it to the specified room
        }
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

    /**
     * Move the player to the next Level.
     */
    private void goToNextLevel() {
        this.currentLevelID++;
        this.currentRoom = getCurrentLevel().getStartRoom();
    }

    /**
     * Finds all available rooms next to the current room.
     * A room is considered available if it is UP, DOWN, LEFT, RIGHT of the current room
     * @return the list of all available rooms next to the current room
     */
    private List<Room> getAvailableRooms() {
        final LevelFactoryUtils lvlUtils = new LevelFactoryUtils();
        final Point2D roomCoord = this.currentRoom.getCoords();
        final List<Point2D> neighborRoomCoords = lvlUtils.getNeighborRooms(roomCoord);

        return getCurrentLevel().getRooms().stream()
                .filter(r -> neighborRoomCoords.contains(r.getCoords()))
                .collect(Collectors.toList());
    }
}
