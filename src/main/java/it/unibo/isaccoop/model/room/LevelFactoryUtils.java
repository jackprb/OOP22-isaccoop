package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Delegated class that contains utility methods to help {@link LevelFactoryImpl} creating 
 * a room.
 */
public final class LevelFactoryUtils {

    private final Player player;

    /**
     * Constructor. Requires the player to be placed in the START room.
     * @param player the player to be placed in the START room
     */
    public LevelFactoryUtils(final Player player) {
        this.player = player;
    }

    /**
     * Generates dynamically the coordinates that will be used as positions
     * for the rooms in this level.
     * @param numberOfRooms the number of rooms that will be in this level
     * @return the list of coordinates to be assigned to the rooms
     */
    public List<Pair<Integer, Integer>> generateRoomCoordinates(final int numberOfRooms) {
        // initial position for the first room of the level
        Pair<Integer, Integer> roomPos = new ImmutablePair<>(0, 0);
        final List<Pair<Integer, Integer>> list = new LinkedList<>();

        for (int i = 0; i < numberOfRooms; i++) {
            if (isValidCoord(roomPos) && !list.contains(roomPos)) {
                list.add(roomPos);
                roomPos = getNewCoordinateAlongDirection(roomPos, Direction.RIGHT);
            }
        }
        return list;
    }

    /**
     * Get a new coordinate from the current coordinate coord, along the specified direction dir.
     * @param coord the current coordinate from which calculate the new coordinate
     * @param dir the direction along which the coordinate has to ben calculated
     * @return the new coordinate calculated from coordinate coord along direction dir
     */
    public Pair<Integer, Integer> getNewCoordinateAlongDirection(
            final Pair<Integer, Integer> coord, final Direction dir) {
        return new ImmutablePair<>(coord.getLeft() + dir.getX(), coord.getRight() + dir.getY());
    }

    /**
     * check if specified coordinate is valid (inside the grid).
     * @param coord the coordinate to be checked
     * @return true if the coordinate is valid (inside the grid), false otherwise
     */
    public boolean isValidCoord(final Pair<Integer, Integer> coord) {
        return coord.getLeft() >= 0 && coord.getRight() >= 0;
    }

    /**
     * Method to associate rooms to their coordinates.
     * @param coordsList
     * @return the list of created rooms.
     */
    public List<Room> createRooms(final List<Pair<Integer, Integer>> coordsList) {
        final RoomFactory rFactory = new RoomFactoryImpl(coordsList.size(), player);
        final List<Room> rooms = new LinkedList<>();

        for (final Pair<Integer, Integer> coord: coordsList) {
            rooms.add(rFactory.buildRoomInProperOrder(pairToPoint2D(coord)));
        }
        return rooms;
    }

    /**
     * Convert a pair into a Point2D.
     * @param pair the initial pair
     * @return the pair converted into a Point2D
     */
    private Point2D pairToPoint2D(final Pair<Integer, Integer> pair) {
        return new Point2D(pair.getLeft(), pair.getRight());
    }
}
