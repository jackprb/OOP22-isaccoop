package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link LevelController}.
 */
public final class LevelControllerImpl implements LevelController {

    private final List<Level> lvl = new LinkedList<>();
    private int currentLevelID;
    private final Player player;

    /**
     * Create a game with the specified number of levels.
     * @param numberOfLevels the number of levels to create
     * @param engine the {@link GameEngine} to be attached to this level
     */
    public LevelControllerImpl(final int numberOfLevels, final GameEngine engine) {
        this.player = new Player(engine.getController("keyMove"), engine.getController("keyShot"));
        final LevelFactory lvlFactory = new LevelFactoryImpl(engine);
        this.currentLevelID = 0;
        Stream.iterate(0, i -> i + 1)
            .limit(numberOfLevels)
            .forEach(r -> this.lvl.add(lvlFactory.createLevel()));
    }

    @Override
    public Level getCurrentLevel() {
        return this.lvl.get(currentLevelID);
    }

    @Override
    public int getCurrentLevelIndex() {
        return this.currentLevelID;
    }

    @Override
    public int getNumberOfLevels() {
        return this.lvl.size();
    }

    @Override
    public List<Room> getRoomsOfCurrentLevel() {
        return List.copyOf(getCurrentLevel().getRooms());
    }

    @Override
    public int getNumberOfRoomsOfCurrentLevel() {
        return getRoomsOfCurrentLevel().size();
    }

    @Override
    public Point2D getCurrentRoomCoord() {
        return getCurrentRoom().getCoords();
    }

    @Override
    public Room getCurrentRoom() {
        return getCurrentLevel().getRooms().stream()
                .filter(r -> r.getPlayer().isPresent())
                .findFirst().get();
    }

    @Override
    public Player getPlayer() {
        return getCurrentRoom().getPlayer().get();
    }

    @Override
    public boolean isRoomComplete(final Room room) {
        return room.isComplete();
    }

    @Override
    public Map<Direction, Room> getAccessibleRooms() {
        return getCurrentLevel().getNearRooms();
    }

    @Override
    public Optional<Room> getPreviousRoom() {
        return getPrevNextRoom(Direction.LEFT);
    }

    @Override
    public Optional<Room> getNextRoom() {
        return getPrevNextRoom(Direction.RIGHT);
    }

    @Override
    public boolean moveToRoom(final Room room) {
        final Player player = getPlayer();
        if (getCurrentRoom().isComplete() && getCurrentRoom().removePlayer()) {
            room.addPlayer(player);
            return true;
        }
        return false;
    }

    @Override
    public boolean isCurrentLevelComplete() {
        if (getCurrentLevel().isLevelComplete()) {
            goToNextLevel();
            return true;
        }
        return false;
    }

    @Override
    public boolean areAllLevelsComplete() {
        return this.lvl.stream().allMatch(l -> l.isLevelComplete());
    }

    /**
     * Get the previous or next room of current room.
     * @param dir {@link Direction#RIGHT} to get the next room,
     * {@link Direction#LEFT} to get the previous one
     * @return the previous or next room of current room, or Optional.empty if not available
     */
    private Optional<Room> getPrevNextRoom(final Direction dir) {
        final Point2D coord = new LevelFactoryUtils()
                .getNewCoordinateAlongDirection(getCurrentRoomCoord(), dir);
        return getCurrentLevel().getRooms().stream()
                .filter(r -> r.getCoords().equals(coord))
                .findFirst();
    }

    /**
     * Move the player to the next Level.
     */
    private void goToNextLevel() {
        this.currentLevelID++;
    }

    /**
     * Finds all available rooms next to the current room.
     * A room is considered available if it is UP, DOWN, LEFT, RIGHT of the current room
     * @return the list of all available rooms next to the current room
     */
    private List<Room> getAvailableRooms() {
        final Point2D roomCoord = getCurrentRoom().getCoords();
        final List<Point2D> neighborRoomCoords = new LevelFactoryUtils().getNeighborRooms(roomCoord);

        return getCurrentLevel().getRooms().stream()
                .filter(r -> neighborRoomCoords.contains(r.getCoords()))
                .collect(Collectors.toUnmodifiableList());
    }
}
