package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.graphics.PlayerGraphicsComponents;
import it.unibo.isaccoop.model.common.Direction;
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
        this.player = new Player(engine.getController("keyMove"), engine.getController("keyShot"), new PlayerGraphicsComponents());
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
        if (isValidNewRoom(room) && getCurrentRoom().isComplete() && getCurrentRoom().removePlayer()) {
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
     * @param dir {@link Direction#RIGHT} to get the next room,<br>
     * {@link Direction#LEFT} to get the previous one
     * @return the previous or next room of current room, or Optional.empty if not available
     */
    private Optional<Room> getPrevNextRoom(final Direction dir) {
        final var prevNextRoom = getAccessibleRooms().entrySet().stream()
                .filter(e -> e.getKey() == dir).findFirst();
        if (prevNextRoom.isPresent()) {
            return Optional.of(prevNextRoom.get().getValue());
        }
        return Optional.empty();
    }

    /**
     * Move the player to the next Level.
     */
    private void goToNextLevel() {
        this.currentLevelID++;
    }

    private boolean isValidNewRoom(final Room destRoom) {
        return getCurrentRoom().getCoords().getX() - destRoom.getCoords().getX() <= 1.0
                && getCurrentRoom().getCoords().getY() - destRoom.getCoords().getY() <= 1.0;
    }
}
