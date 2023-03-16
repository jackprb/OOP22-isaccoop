package it.unibo.isaccoop.model.room;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.common.MapElementImpl;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link Room}.
 */
public final class RoomImpl extends MapElementImpl implements Room {

    private final List<Door> doors = new LinkedList<>();
    private final RoomType roomType;
    private final AIEnemy roomAI;
    //lista powerup, obstacles, enemy, optional<Boss>

    /**
     * @param width horizontal dimension of this {@link Room}
     * @param height vertical dimension of this {@link Room}
     * @param coord coordinate of this {@link Room}
     * @param doors list of all the doors in this {@link Room}
     * @param roomType type of this {@link Room}
     * @param roomAI {@link AIEnemy} impl to attach to this {@link Room}
     */
    public RoomImpl(final int width, final int height,
            final Pair<Double, Double> coord, final List<Door> doors, final RoomType roomType,
            final AIEnemy roomAI) {
        super(width, height, coord);
        this.doors.addAll(doors);
        this.roomType = roomType;
        this.roomAI = roomAI;
    }

    @Override
    public List<Door> getDoors() {
        return Collections.unmodifiableList(this.doors);
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    /**
     * Get {@link AIEnemy} attached to this {@link Room}.
     *
     * @return {@link AIEnemy} impl attached to this {@link Room}
     * */
    public AIEnemy getRoomAI() {
        return roomAI;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(doors, roomType);
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
        return Objects.equals(doors, other.doors) && roomType == other.roomType;
    }

}
