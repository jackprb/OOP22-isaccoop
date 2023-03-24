package it.unibo.isaccoop.model.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.ai.ConcreteAIEnemy;
import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.creator.ConcreteCreatorFactory;
import it.unibo.isaccoop.model.creator.CreatorFactory;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.spawn.SpawnOrdered;
import it.unibo.isaccoop.model.spawn.SpawnRandom;

/**
 * Class to model the Builder pattern, used to build a {@link Room}, using the "fluent" style.
 */
public class RoomBuilder {

    /**
     * Static class to actually implement the {@link RoomBuilder}.
     */
    public static class Builder {
        //basic and minimal fields (set with constructor)
        private final int width;
        private final int height;

        // other basic field (set with their dedicated methods)
        private Optional<Point2D> coord = Optional.empty();
        private Optional<RoomType> roomType = Optional.empty();

        // optional fields (to set with their dedicated methods)
        private Optional<List<Item>> items = Optional.empty();
        private Optional<List<PowerUp>> powerups = Optional.empty();
        private Optional<Player> player = Optional.empty();
        private Optional<List<Enemy>> enemies = Optional.empty();
        private Optional<AIEnemy> roomAI = Optional.empty();

        // factory that creates enemies
        private final CreatorFactory creatorFactory = new ConcreteCreatorFactory();

        /**
         * To build a Room, use {@link RoomFactory} instead. <br>
         *
         * It is required to call this constructor first, 
         * then at least the REQUIRED methods.
         * <br> At the end, call the method build().
         *
         * @param width the horizontal dimension of this room
         * @param height the vertical dimension of this room
         */
        public Builder(final int width, final int height) {
            this.width = width;
            this.height = height;
        }

        /**
         * Method to set the coordinate of this room inside the level,
         * REQUIRED for ALL rooms.
         *
         * @param coord the coordinate of this room inside the level
         * @return this builder
         */
        public Builder putCoord(final Point2D coord) {
            this.coord = Optional.of(coord);
            return this;
        }

        /**
         * Method to set the room type, REQUIRED for ALL rooms.
         *
         * @param roomType the type of room to be created
         * @return this builder
         */
        public Builder roomType(final RoomType roomType) {
            this.roomType = Optional.of(roomType);
            return this;
        }

        /**
         * Method to put items inside this room. ONLY for STANDARD rooms.
         * 
         * @return this builder
         */
        public Builder putItems() {
            if (this.roomType.get() == RoomType.STANDARD) {
                this.items = Optional.of(creatorFactory.createItems().create());
                new SpawnRandom().setPosition(new ArrayList<MapElement>(this.items.get()), this.width, this.height);
                return this;
            }
            throw new IllegalStateException("only STANDARD rooms can have items");
        }

        /**
         * Method to put the enemies inside this room (according to roomType). 
         * REQUIRED ONLY for standard and BOSS rooms.
         * 
         * @return this builder
         * @throws IllegalStateException if called on NON STANDARD or NON BOSS rooms
         */
        public Builder putEnemies() {
            if (canRoomHaveEnemies()) {
                if (this.roomType.get() == RoomType.BOSS) {
                    this.enemies = Optional.of(creatorFactory.createBoss().create());
                } else {
                    this.enemies = Optional.of(creatorFactory.createEnemies().create());
                }
                new SpawnRandom().setPosition(new ArrayList<MapElement>(this.enemies.get()), 
                        this.width, this.height);
                this.putAI();
                return this;
            }
            throw new IllegalStateException("only STANDARD and BOSS rooms can have enemies");
        }

        /**
         * Method to put the player inside this room. ONLY for the START room.
         * 
         * @param player the player to be put inside this room
         * @return this builder
         * @throws IllegalStateException if called on NON START room
         */
        public Builder putPlayer(final Player player) {
            if (this.roomType.get() == RoomType.START) {                
                this.player = Optional.of(player);
                return this;
            }
            throw new IllegalStateException("the player must be put ONLY in the START room");
        }

        /**
         * Method to put the powerups inside this room. ONLY for the SHOP and TREASURE rooms.
         * 
         * @return this builder
         * @throws IllegalStateException if called on NON SHOP or NON TREASURE rooms
         */
        public Builder putPowerUps() {
            if(canRoomHavePowerUps()) {   
                if (this.roomType.get() == RoomType.SHOP) { // for SHOP room
                    this.powerups = Optional.of(creatorFactory.createShopPowerUps().create());
                } else { // for TREASURE ROOM
                    this.powerups = Optional.of(creatorFactory.createTreasurePowerUps().create());
                }
                new SpawnOrdered().setPosition(new ArrayList<MapElement>(
                        this.powerups.get()), this.width, this.height);
                return this;
            }
            throw new IllegalStateException("only SHOP and TREASURE room can have powerups");
        }

        /**
         * Method to build the Room.
         * First, you need to call the constructor, then the REQUIRED methods
         * to set this Room's fields. <br> After that, you can call this method.
         *
         * @throws IllegalStateException if current Room has some REQUIRED fields unset.
         * @return the build Room
         */
        public Room build() {
            if (areThereMinimumRequirements()) {
                throw new IllegalStateException("set all required fields: use putCoords() and roomType() methods.");
            }
            if (canRoomHaveEnemies() && (this.roomAI.isEmpty() || this.enemies.isEmpty())) {
                throw new IllegalStateException("this room (" + this.roomType.get() + ") needs an AiEnemy object");
            }
            if (this.roomType.get() == RoomType.START && this.player.isEmpty()) {
                throw new IllegalStateException("you must put the player in this in this room (START room)");
            }
            return new RoomImpl(this.width, this.height, this.coord.get(),
                    this.roomType.get(), this.roomAI, this.items, this.powerups, 
                    this.player, this.enemies);
        }

        /**
         * Method to set the AI inside this room, ONLY for STANDARD and BOSS rooms.
         */
        private void putAI() {
            this.roomAI = Optional.of(new ConcreteAIEnemy(this.enemies.get()));
        }

        /**
         * Check if the current room to build needs the AiEnemy object.
         * @return true if the room need the AiEnemy object, false otherwise
         */
        private boolean canRoomHaveEnemies() {
            return this.roomType.get() == RoomType.STANDARD || this.roomType.get() == RoomType.BOSS;
        }
        
        /**
         * Check if the current room to build can have powerups.
         * @return true if the room can have powerups, false otherwise
         */
        private boolean canRoomHavePowerUps() {
            return this.roomType.get() == RoomType.SHOP || this.roomType.get() == RoomType.TREASURE;
        }
        
        /**
         * Method to check if the minimum requirements are satisfied.
         * @return true if the minimum requirements are satisfied
         */
        private boolean areThereMinimumRequirements() {
            return this.coord.isPresent() && this.roomType.isPresent();
        }
    }
}
