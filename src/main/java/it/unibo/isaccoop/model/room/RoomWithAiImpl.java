package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link Room}.
 */
public class RoomWithAiImpl extends AbstractRoom implements RoomWithAi{

    private final AIEnemy roomAI; //contains the list of enemies
    //lista powerup, obstacles, optional<Boss>

    /**
     * @param id id of this {@link Room}
     * @param width horizontal dimension of this {@link Room}
     * @param height vertical dimension of this {@link Room}
     * @param coord coordinate of this {@link Room}
     * @param doors list of all the doors in this {@link Room}
     * @param roomType type of this {@link Room}
     * @param roomAI {@link AIEnemy} impl to attach to this {@link Room}
     */
    public RoomWithAiImpl(final int id, final int width, final int height,
            final Pair<Integer, Integer> coord, final List<Door> doors, final RoomType roomType,
            final AIEnemy roomAI) {
        super(id, width, height, coord, roomType);
        this.roomAI = roomAI;
    }

    @Override
    public AIEnemy getRoomAI() {
        return this.roomAI;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(super.getID());
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
        final RoomWithAiImpl other = (RoomWithAiImpl) obj;
        if (roomAI == null) {
            if (other.roomAI != null) {
                return false;
            }
        } else if (!roomAI.equals(other.roomAI)) {
            return false;
        }
        return true;
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
        private AIEnemy roomAI;
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
                final Pair<Integer, Integer> coord, final RoomType roomType,
                final AIEnemy roomAI) {
            this.id = id;
            this.width = width;
            this.height = height;
            this.coord = coord;
            this.roomType = roomType;
            this.roomAI = roomAI;
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
         * Method to set the AI inside this room.
         * @param roomAI the AI of this room
         * @return this builder
         */
        public Builder setAI(final AIEnemy roomAI) {
            this.roomAI = roomAI;
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
            return new RoomWithAiImpl(this.id, this.width, this.height, this.coord, this.doors, this.roomType, this.roomAI);
        }
    }
}
