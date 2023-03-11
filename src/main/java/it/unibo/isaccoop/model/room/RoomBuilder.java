package it.unibo.isaccoop.model.room;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Class to model the Builder pattern, used to build a {@link Room}, using the "fluent" style. 
 */
public class RoomBuilder {

    /**
     * Static class to actually implement the Room builder.
     */
    public static class Builder {
        //basic and minimal fields (set with constructor)
        private final int id;
        private final int width; 
        private final int height; 
        private final Pair<Integer, Integer> coord;
        private RoomType roomType;

        //other basic field (set with its dedicated method)
        private List<Door> doors = new LinkedList<>();

        //optional fields
        private Optional<AIEnemy> roomAI = Optional.empty();
        //lista powerup, obstacles, enemy, optional<Boss>

        /**
         * Build a simple empty {@link Room}. <br>
         * To build a Room, it is required to call this constructor first, then the other methods. <br>
         * At the end, call the method build().
         * 
         * @param id id of this room
         * @param width the horizontal dimension of this room
         * @param height the vertical dimension of this room
         * @param coord the coordinates of this room inside the level
         * @param roomType the type of this room
         */
        public Builder(final int id, final int width, final int height, 
                final Pair<Integer, Integer> coord) {
            this.id = id;
            this.width = width;
            this.height = height;
            this.coord = coord;
        }

        /**
         * Method to place the doors inside this room.
         * @param doors the doors to be added inside this room
         * @return this builder
         */
        public Builder putDoors(final List<Door> doors) {
            this.doors = doors;
            return this;
        }
        
        /**
         * Method to set the room type.
         * @param roomType the type of room to be created
         * @return this builder
         */
        public Builder roomType(final RoomType roomType) {
            this.roomType = roomType;
            return this;
        }

        /**
         * Method to set the AI inside this room, ONLY for STANDARD and BOSS rooms.
         * @param roomAI the AI of this room
         * @return this builder
         * @throws IllegalStateException if called on NON STANDARD or NON BOSS rooms
         */
        public Builder putAI(final AIEnemy roomAI) {
            if (checkConditionForAiRoom()) {
                this.roomAI = Optional.of(roomAI);
                return this;
            }
            throw new IllegalStateException("only STANDARD and BOSS rooms can have an AI");
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
            if (this.doors.isEmpty()) {
                throw new IllegalStateException("this room needs at least 1 door");
            }
            if (this.roomAI.isEmpty() && checkConditionForAiRoom()) {
                throw new IllegalStateException("this room needs an AiEnemy object");
            }
            return new RoomImpl(this.id, this.width, this.height, this.coord, 
                    this.roomType, this.doors, this.roomAI);
        }

        /**
         * Check if the current room to build needs the AiEnemy object.
         * @return true if the room need the AiEnemy object, false otherwise
         */
        private boolean checkConditionForAiRoom() {
            return this.roomType == RoomType.STANDARD || this.roomType == RoomType.BOSS;
        }
    }
}
