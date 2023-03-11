package it.unibo.isaccoop.model.room;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.common.MapElementImpl;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Abstract {@link Room} that implements the main methods.
 */
public class RoomImpl extends MapElementImpl implements Room {

    private final List<Door> doors = new LinkedList<>();
    private final RoomType roomType;
    private Optional<AIEnemy> roomAi = Optional.empty();

    /**
     * 
     * @param id id of this room
     * @param width horizontal dimension of this room
     * @param height vertical dimension of this room
     * @param coord coordinates of this room inside the level
     * @param roomType type of this room
     */
    protected RoomImpl(final int id, final int width, final int height, 
            final Pair<Integer, Integer> coord, final RoomType roomType,
            final List<Door> doors, Optional<AIEnemy> roomAi) {
        super(id, width, height, coord);
        this.roomType = roomType;
        this.doors.addAll(doors);
        this.roomAi = roomAi;
    }

    @Override
    public List<Door> getDoors() {
        return Collections.unmodifiableList(this.doors);
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public Optional<AIEnemy> getRoomAI(){
        return this.roomAi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(super.getID(), super.getCoord(), this.roomType);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
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
