package it.unibo.isaccoop.model.room;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link LevelFactory}.
 */
public final class LevelFactoryImpl implements LevelFactory {

    private static final int MAX_NUMBER_OF_ROOMS = 30;
    private static final int MIN_NUMBER_OF_ROOMS = 6;
    private final LevelFactoryUtils lvlFactoryUtils = new LevelFactoryUtils();

    @Override
    public Level createLevel() {
        final int numberOfRooms = ThreadLocalRandom.current().nextInt(
                MAX_NUMBER_OF_ROOMS - MIN_NUMBER_OF_ROOMS) + MIN_NUMBER_OF_ROOMS;
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
