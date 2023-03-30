package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link LevelFactory}.
 */
public final class LevelFactoryImpl implements LevelFactory {

    private int numberOfRooms;
    private final List<Pair<Integer, Integer>> roomCoords = new LinkedList<>();
    // each level must have at least 5 rooms, one for each RoomType
    private static final int MIN_NUMBER_OF_ROOMS = RoomType.values().length;

    /**
     * Empty constructor.
     */
    public LevelFactoryImpl() {
        this.roomCoords.clear();
    }

    @Override
    public Level createLevel(final int numberOfRooms) {
        if (numberOfRooms < MIN_NUMBER_OF_ROOMS) {
            throw new IllegalArgumentException("a level must have at least " + MIN_NUMBER_OF_ROOMS + " rooms");
        }
        this.numberOfRooms = numberOfRooms;
        setRoomCoordinates();

        final List<Room> rooms = createRooms();
        final Level lvl = new LevelImpl();
        lvl.putRooms(rooms);
        return lvl;
    }

    /**
     * Generates dynamically the coordinates that will be used as positions
     * for the rooms in this level.
     */
    private void setRoomCoordinates() {
        // initial position for the first room of the level
        Pair<Integer, Integer> roomPos = new ImmutablePair<>(0, 0);

        for (int i = 0; i < this.numberOfRooms; i++) {
            if (isValidCoord(roomPos) && !this.roomCoords.contains(roomPos)) {
                this.roomCoords.add(roomPos);
                roomPos = getNewCoordinateAlongDirection(roomPos, Direction.RIGHT);
            }
        }
    }

    /**
     * Get a new coordinate from the current coordinate coord, along the specified direction dir.
     * @param coord the current coordinate from which calculate the new coordinate
     * @param dir the direction along which the coordinate has to ben calculated
     * @return the new coordinate calculated from coordinate coord along direction dir
     */
    private Pair<Integer, Integer> getNewCoordinateAlongDirection(
            final Pair<Integer, Integer> coord, final Direction dir) {
        return new ImmutablePair<>(coord.getLeft() + dir.getX(), coord.getRight() + dir.getY());
    }

    /**
     * check if specified coordinate is valid (inside the grid).
     * @param coord the coordinate to be checked
     * @return true if the coordinate is valid (inside the grid), false otherwise
     */
    private boolean isValidCoord(final Pair<Integer, Integer> coord) {
        return coord.getLeft() >= 0 && coord.getRight() >= 0;
    }

    /**
     * Method to associate rooms to their coordinates.
     * @return the list of created rooms.
     */
    private List<Room> createRooms() {
        final RoomFactory rFactory = new RoomFactoryImpl();
        final List<Room> rooms = new LinkedList<>();
        for (int i = 0; i < this.roomCoords.size(); i++) {
            final var coord = pair2point2D(this.roomCoords.get(rooms.size()));
            if (i < RoomType.values().length) {
                // create a room for each RoomType (BOSS, SHOP, TREASURE, START, STANDARD)
                rooms.add(rFactory.buildRoomOfType(RoomType.values()[i], coord));
            } else {
                // the remaining ones must be STANDARD
                rooms.add(rFactory.buildStandardRoom(coord));
            }
        }
        return rooms;
    }

    /**
     * Convert a pair into a Point2D.
     * @param pair the initial pair
     * @return the pair converted into a Point2D
     */
    private Point2D pair2point2D(final Pair<Integer, Integer> pair) {
        return new Point2D(pair.getLeft(), pair.getRight());
    }
}
