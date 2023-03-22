package it.unibo.isaccoop.model.room;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.collision.Event;
import it.unibo.isaccoop.model.common.MapElementImpl;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.player.Player;

/**
 * Implementation of {@link Room}.
 */
public final class RoomImpl extends MapElementImpl implements Room {

    private final RoomType roomType;
    private final Optional<AIEnemy> roomAi;
    private final Optional<List<Item>> items;
    private final Optional<List<PowerUp>> powerups;
    private final Optional<Player> player;
    private Queue<Event> eventsQueue;

    /**
     * Use {@link RoomFactory} to create a new {@link Room}.
     * @param width horizontal dimension of this room
     * @param height vertical dimension of this room
     * @param coord coordinates of this room inside the level
     * @param roomType type of this room
     * @param roomAI the AiEnemy for this room
     * @param items the items in this room
     * @param powerups the powerups in this room
     * @param player the player
     */
    public RoomImpl(final int width, final int height,
            final Point2D coord, /*final List<Door> doors,*/ final RoomType roomType,
            final Optional<AIEnemy> roomAI, final Optional<List<Item>> items, 
            final Optional<List<PowerUp>> powerups, final Player player) {
        super(width, height, coord);
        this.roomType = roomType;
        //this.doors.addAll(doors);
        this.roomAi = roomAI;
        this.items = items;
        this.powerups = powerups;
        this.player = Optional.of(player);
    }

    /*@Override
    public List<Door> getDoors() {
        return Collections.unmodifiableList(this.doors);
    }*/

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public Optional<AIEnemy> getRoomAI() {
        return this.roomAi;
    }

    @Override
    public Optional<List<Item>> getItems() {
        return this.items;
    }

    @Override
    public Optional<List<PowerUp>> getPowerUps() {
        return this.powerups;
    }

    @Override
    public Optional<Player> getPlayer() {
        return this.player;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public void updateRoom() {
        // TODO Auto-generated method stub
    }

    @Override
    public void notifyEvent(final Event event) {
        this.eventsQueue.add(event);
    }

    @Override
    public void executeEvents() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(super.getCoords(), this.roomType);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoomImpl other = (RoomImpl) obj;
        return roomType == other.roomType;
    }
}
