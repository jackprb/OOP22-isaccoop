package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.graphics.PlayerGraphicsComponent;
import it.unibo.isaccoop.model.common.Direction;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link Level}.
 */
public final class LevelImpl implements Level {

    private final List<Room> rooms = new LinkedList<>();
    private final Optional<Player> player;

    /**
     * Empty Constructor.
     * @param engine
     */
    public LevelImpl(final GameEngine engine) {
        this.player = Optional.of(new Player(engine.getController("keyMove"), engine.getController("keyShot"),
                                    new PlayerGraphicsComponent()));
    }

    @Override
    public void putRooms(final List<Room> roomList) {
        if (roomList.isEmpty() || roomList.size() < RoomType.values().length) {
            throw new IllegalArgumentException("This level must have at least " + RoomType.values().length
                    + " rooms");
        }
        if (this.rooms.isEmpty()) {
            this.rooms.addAll(roomList);
            getStartRoom().addPlayer(this.player.get());
        } else {
            throw new IllegalStateException("This level already has a room list");
        }
    }

    @Override
    public List<Room> getRooms() {
        return List.copyOf(this.rooms);
    }

    @Override
    public boolean isLevelComplete() {
        return this.rooms.stream().allMatch(r -> r.isComplete());
    }

    @Override
    public Room getStartRoom() {
        return this.rooms.stream().filter(r -> r.getRoomType() == RoomType.START)
                .findFirst().get();
    }

    @Override
    public Room getCurrentRoom() {
        return this.rooms.stream().filter(r -> r.getPlayer().isPresent())
                .findFirst().get();
    }

    @Override
    public Map<Direction, Room> getNearRooms() {
        return new LevelUtils().getNearAccessibleRooms(getCurrentRoom(), List.copyOf(this.rooms));
    }

    @Override
    public Player getPlayer() {
        return getCurrentRoom().getPlayer().get();
    }

    @Override
    public boolean isCurrentRoomComplete() {
        return getCurrentRoom().isComplete();
    }
}
