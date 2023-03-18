package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link LevelFactory}.
 */
public final class LevelFactoryImpl implements LevelFactory {

    private int numberOfRooms;
    private int gridRows;
    private int gridCols;
    private final List<Point2D> roomCoords = new LinkedList<>();
    private Level lvl;
    // ogni livello deve avere almeno 5 room, una per ogni tipo
    private static final int MIN_NUMBER_OF_ROOMS = 5;

    @Override
    public Level createLevel(final int numberOfRooms, final int gridRows, final int gridCols) {
        if (!(numberOfRooms >= MIN_NUMBER_OF_ROOMS && gridRows > 0 && gridCols > 0 
                && numberOfRooms <= gridRows * gridCols)) {
            throw new IllegalArgumentException("");
        }
        this.numberOfRooms = numberOfRooms;
        this.gridRows = gridRows;
        this.gridCols = gridCols;
        this.roomCoords.clear();
        setRoomCoordinates();

        final List<Room> rooms = createRooms();
        this.lvl.putRooms(rooms);
        return this.lvl;
    }

    /**
     * Generates dynamically the coordinates that will be used as positions 
     * for the rooms in this level.
     */
    private void setRoomCoordinates() {
        //posiz iniziale per posizionare stanze nel livello
        Point2D roomPos = new Point2D(0.0, 0.0);

        while (this.roomCoords.size() < this.numberOfRooms) {
            if (isValidCoord(roomPos) && !this.roomCoords.contains(roomPos)) {
                this.roomCoords.add(roomPos);
                //ottiene possibili direzioni per la prossima room
                final List<Point2D> availablePos = getAvailablePositionsFrom(roomPos);
                if (!availablePos.isEmpty()) { //se ci sono direzioni disponibili
                    roomPos = availablePos.get(new Random().nextInt(availablePos.size())); //ne sceglie una
                }
            } else {
                roomPos = findNewAvailableCoordinate();
            }
        }
    }

    /**
     * Find a new available coordinate around one of the coordinates already added to the roomCoords list.
     * To be used when coordinates generation fails to complete (e.g.: when a loop of rooms is created).
     * 
     * @return a coordinate already present in the coordinates list, 
     * which has at least 1 available cell around itself
     */
    private Point2D findNewAvailableCoordinate() {
        for (int i = this.roomCoords.size() - 1; i >= 0; i--) {
            final List<Point2D> list = getAvailablePositionsFrom(this.roomCoords.get(i));
            if (!list.isEmpty()) {
                return list.get(0);
            }
        }
        return new Point2D(-1.0, -1.0);
    }

    /**
     * finds all available positions/coordinates around the specified coordinate currPos.
     * @param currPos the current coordinate
     * @return a list of available coordinates around the specified coordinare currPos 
     */
    private List<Point2D> getAvailablePositionsFrom(final Point2D currPos) {
        final List<Point2D> pos = new LinkedList<>();
        for (final var dir: Direction.values()) {
            final Point2D newPos = getNewCoordinateAlongDirection(currPos, dir);
            if (isValidCoord(newPos) && !this.roomCoords.contains(newPos)) {
                pos.add(newPos);
            }
        }
        return pos;
    }

    /**
     * get a new coordinate from the current coordinate coord, along the specified direction dir.
     * @param coord the current coordinate from which calculate the new coordinate
     * @param dir the direction along which the coordinate has to ben calculated
     * @return the new coordinate calculated from coordinate coord along direction dir
     */
    private Point2D getNewCoordinateAlongDirection(
            final Point2D coord, final Direction dir) {
        return new Point2D(coord.getX()+ dir.getX(), coord.getY() + dir.getY());
    }

    /**
     * check if specified coordinate is valid (inside the grid).
     * @param coord the coordinate to be checked
     * @return true if the coordinate is valid (inside the grid), false otherwise
     */
    private boolean isValidCoord(final Point2D coord) {
        return coord.getX() >= 0 && coord.getY() >= 0 
                && coord.getY() < this.gridRows && coord.getX() < this.gridCols;
    }

    /**
     * Method to associate rooms to their coordinates. 
     * @return the list of created rooms.
     */
    private List<Room> createRooms() {
        final RoomFactory rFactory = new RoomFactoryImpl();
        final List<Room> rooms = new LinkedList<>();
        for (int i = 0; i < this.roomCoords.size(); i++) {
            if (i < RoomType.values().length) {
                // crea una room di ogni tipo (BOSS, SHOP, TREASURE, START, STANDARD)
                rooms.add(rFactory.buildRoomOfType(RoomType.values()[i], this.roomCoords.get(rooms.size())));
            } else {
                // quelle rimanenti devono essere di tipo STANDARD
                rooms.add(rFactory.buildStandardRoom(this.roomCoords.get(rooms.size())));
            }
        }
        return rooms;
    }
}
