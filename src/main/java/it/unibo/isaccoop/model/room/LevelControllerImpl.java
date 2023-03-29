package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link LevelController}.
 */
public final class LevelControllerImpl implements LevelController {

    private static final int MAX_NUMBER_OF_ROOMS = 30;
    private static final int MIN_NUMBER_OF_ROOMS = 6;

    private final List<Level> lvl = new LinkedList<>();
    private int currentLevelID;
    private Room currentRoom;
    private final Player player = new Player();
    private final InputController inputController;
    
    /**
     * Create a game with the specified number of levels.
     * @param numberOfLevels the number of levels to create
     */
    public LevelControllerImpl(final int numberOfLevels, final InputController inputController) {
        final LevelFactoryImpl lvlFactory = new LevelFactoryImpl(this.player);
        this.inputController = inputController;
        this.currentLevelID = 0;
        Stream.iterate(0, i -> i + 1)
            .limit(numberOfLevels)
            .forEach(r -> {
                final int numberOfRooms = ThreadLocalRandom.current().nextInt(
                        MAX_NUMBER_OF_ROOMS - MIN_NUMBER_OF_ROOMS) + MIN_NUMBER_OF_ROOMS;
                this.lvl.add(lvlFactory.createLevel(numberOfRooms));
            });
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

    private void goToNextLevel() {
        this.currentLevelID++;
    }

    private List<Room> getAvailableRooms() {
        final LevelFactoryUtils lvlUtils = new LevelFactoryUtils(this.player);
        // thes the coordinate of current room, as a Pair<Integer, Integer>
        final Pair<Integer, Integer> roomCoord = point2DToPair(this.currentRoom.getCoords());
        final List<Pair<Integer, Integer>> neighborRoomCoords = new LinkedList<>();

        // get all neighbor room coordinates (i.e.: the rooms next to the current room, where the player can go)
        for (final var dir: Direction.values()) {
            final var newCoord = lvlUtils.getNewCoordinateAlongDirection(roomCoord, dir);
            if (lvlUtils.isValidCoord(newCoord)) {
                neighborRoomCoords.add(newCoord);
            }
        }
        return getCurrentLevel().getRooms().stream()
        .filter(r -> neighborRoomCoords.contains(r.getCoords()))
        .collect(Collectors.toList());
        //r.getCoords().getX() - roomCoord.getLeft() == 1)
    }

    /**
     * Convert a pair into a Point2D.
     * @param point2d the initial Point2D
     * @return the pair converted into a Point2D
     */
    private Pair<Integer, Integer> point2DToPair(final Point2D point2d) {
        return new ImmutablePair<>((int) point2d.getX(), (int) point2d.getY());
    }
}
