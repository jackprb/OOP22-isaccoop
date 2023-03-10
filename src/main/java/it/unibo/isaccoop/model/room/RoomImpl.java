package it.unibo.isaccoop.model.room;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.MapElementImpl;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link Room}.
 */
public class RoomImpl extends MapElementImpl implements Room {

    private final List<Door> doors = new LinkedList<>();
    private final RoomType roomType;
    //lista powerup, obstacles, enemy, optional<Boss>

    /**
     * @param id id of this {@link Room}
     * @param width horizontal dimension of this {@link Room}
     * @param height vertical dimension of this {@link Room}
     * @param coord coordinate of this {@link Room}
     * @param doors list of all the doors in this {@link Room}
     * @param roomType type of this {@link Room}
     */
    public RoomImpl(final int id, final int width, final int height, 
            final Pair<Integer, Integer> coord, final List<Door> doors, final RoomType roomType) {
        super(id, width, height, coord);
        this.doors.addAll(doors);
        this.roomType = roomType;
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

    /**
     * Class to model the Builder pattern, used to build a {@link Room}, using the fluent style. 
     */
    public static class Builder {
        private int id; 
        private int width; 
        private int height; 
        private Pair<Integer, Integer> coord;
        
        private List<Door> doors = new LinkedList<>();
        private RoomType roomType;
        //lista powerup, obstacles, enemy, optional<Boss>
        
        /**
         * Build a simple empty {@link Room}. <br>
         * To build a Room, it is required to call this constructor first, then the other methods. <br>
         * At the end, call the method build().
         * 
         * @param id the id of this room
         * @param width the horizontal dimension of this room
         * @param height the vertical dimension of this room
         * @param coord the coordinates of this room inside the level
         * @param roomType the type of this room
         */
        public Builder(final int id, final int width, final int height, 
                final Pair<Integer, Integer> coord, final RoomType roomType) {
            this.id = id;
            this.width = width;
            this.height = height;
            this.coord = coord;
            this.roomType = roomType;
        }
        
        /**
         * Method to place the doors inside this room.
         * @param doors the doors to be added inside this room
         * @return this builder
         */
        public Builder setDoors(final List<Door> doors) {
            this.doors = doors;
            return this;
        }
        
        /**
         * Method to build the Room.
         * You need to call the constructor, then the other methods to set this Room's fields.
         * After that, you can call this method.
         * 
         * @throws IllegalStateException if current Room has some fields unset.
         * 
         * @return the build Room
         */
        public Room build() {
            if(this.doors.isEmpty()) {
                throw new IllegalStateException("");
            }
            return new RoomImpl(id, width, height, coord, doors, roomType);
        }
    }
}
