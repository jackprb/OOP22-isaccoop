package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link LevelFactory}.
 */
public final class LevelFactoryImpl implements LevelFactory {

    // each level must have at least 5 rooms, one for each RoomType
    private static final int MIN_NUMBER_OF_ROOMS = RoomType.values().length;
    private final Player player;
    
    /**
     * Put the player.
     * @param player the player to be put inside this level
     */
    public LevelFactoryImpl(final Player player) {
        this.player = player;
    }

    @Override
    public Level createLevel(final int numberOfRooms) {
        if (numberOfRooms < MIN_NUMBER_OF_ROOMS) {
            throw new IllegalArgumentException("a level must have at least " + MIN_NUMBER_OF_ROOMS + " rooms");
        }
        final LevelFactoryUtils lvlFactoryUtils = new LevelFactoryUtils(this.player);
        final List<Pair<Integer, Integer>> roomCoords = new LinkedList<>();
        roomCoords.addAll(lvlFactoryUtils.generateRoomCoordinates(numberOfRooms));

        final List<Room> rooms = lvlFactoryUtils.createRooms(roomCoords);
        final Level lvl = new LevelImpl();
        lvl.putRooms(rooms);
        return lvl;
    }
}
