package it.unibo.isaccoop.model.room;

import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link LevelFactory}.
 */
public final class LevelFactoryImpl implements LevelFactory {

    // each level must have at least 5 rooms, one for each RoomType
    private static final int MIN_NUMBER_OF_ROOMS = RoomType.values().length;
    private final LevelFactoryUtils lvlFactoryUtils = new LevelFactoryUtils();

    @Override
    public Level createLevel(final int numberOfRooms) {
        if (numberOfRooms < MIN_NUMBER_OF_ROOMS) {
            throw new IllegalArgumentException("a level must have at least " + MIN_NUMBER_OF_ROOMS + " rooms");
        }
        final List<Point2D> roomCoords = lvlFactoryUtils.generateRoomCoordinates(numberOfRooms);
        final List<Room> rooms = lvlFactoryUtils.createRooms(roomCoords);
        final Level lvl = new LevelImpl();
        lvl.putRooms(rooms);
        return lvl;
    }

    @Override
    public Player getPlayer() {
        return this.lvlFactoryUtils.getPlayer().get();
    }
}
