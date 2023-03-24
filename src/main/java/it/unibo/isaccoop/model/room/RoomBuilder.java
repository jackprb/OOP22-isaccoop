package it.unibo.isaccoop.model.room;

import java.util.List;
import java.util.Optional;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.ai.ConcreteAIEnemy;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.powerup.PowerUp;

/**
 * Class to model the Builder pattern, to build a {@link Room} using the "fluent" style.
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
        private Optional<List<Enemy>> enemies = Optional.empty();
        private Optional<Player> player = Optional.empty();
        private Optional<AIEnemy> roomAI = Optional.empty();

        // to access utility methods
        private RoomBuilderUtils builderUtils;

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
            this.builderUtils = new RoomBuilderUtils(roomType);
            return this;
        }

        /**
         * Method to put items inside this room. ONLY for STANDARD rooms.
         * 
         * @return this builder
         */
        public Builder putItems() {
            if (this.builderUtils.canRoomHaveItems()) {
                this.items = this.builderUtils.generateItems();
                this.builderUtils.randomSpawn(this.items.get(), this.width, this.height);
                return this;
            }
            throw new IllegalStateException("only STANDARD rooms can have items");
        }

        /**
         * Method to put the enemies inside this room (according to roomType). 
         * REQUIRED ONLY for STANDARD and BOSS rooms.
         * 
         * @return this builder
         * @throws IllegalStateException if called on NON STANDARD or NON BOSS rooms
         */
        public Builder putEnemies() {
            if (this.builderUtils.canRoomHaveEnemies()) {
                this.enemies = this.builderUtils.generateEnemies();
                this.builderUtils.randomSpawn(this.enemies.get(), width, height);
                this.roomAI = Optional.of(new ConcreteAIEnemy(this.enemies.get()));
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
            if (this.builderUtils.canRoomHavePlayer()) {
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
            if (this.builderUtils.canRoomHavePowerUps()) {
                this.powerups = this.builderUtils.generatePowerups();
                this.builderUtils.orderedSpawn(this.powerups.get(), width, height);
                return this;
            }
            throw new IllegalStateException("only SHOP and TREASURE room can have powerups");
        }

        /**
         * Method to build the Room. First, call the constructor, then the REQUIRED methods
         * to set this Room's fields. <br>After that, you can call this method.
         *
         * @throws IllegalStateException if current Room has some REQUIRED fields unset.
         * @return the built Room
         */
        public Room build() {
            if (areThereMinimumRequirements() && canBuildRoom()) {
                return new RoomImpl(this.width, this.height, this.coord.get(),
                        this.roomType.get(), this.roomAI, this.items, this.powerups, 
                        this.player, this.enemies);
            }
            throw new IllegalStateException("some required fields are not set");
        }

        /**
         * Method to check if the minimum requirements are satisfied.
         * @return true if the minimum requirements are satisfied
         */
        private boolean areThereMinimumRequirements() {
            return this.coord.isPresent() && this.roomType.isPresent();
        }

        /**
         * Check if this room can be built. A room can be built only if
         * all required fields are set, depending on the {@link RoomType}.
         * @param builder
         * @return true if the room can be built (all required fields are set),
         * false otherwise
         */
        public boolean canBuildRoom() {
            switch (this.roomType.get()) {
            case START:
                return this.items.isEmpty() && this.player.isPresent() && this.enemies.isEmpty()
                        && this.powerups.isEmpty() && this.roomAI.isEmpty();
            case SHOP:
                return this.items.isEmpty() && this.player.isEmpty() && this.enemies.isEmpty()
                        && this.powerups.isPresent() && this.roomAI.isEmpty();
            case TREASURE:
                return this.items.isEmpty() && this.player.isEmpty() && this.enemies.isEmpty()
                        && this.powerups.isPresent() && this.roomAI.isEmpty();
            case STANDARD:
                return this.items.isPresent() && this.player.isEmpty() && this.enemies.isPresent()
                        && this.powerups.isEmpty() && this.roomAI.isPresent();
            case BOSS:
                return this.items.isEmpty() && this.player.isEmpty() && this.enemies.isPresent()
                        && this.powerups.isEmpty() && this.roomAI.isPresent();
            default:
                return false;
            }
        }
    }
}
