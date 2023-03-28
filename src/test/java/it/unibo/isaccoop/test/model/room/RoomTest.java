package it.unibo.isaccoop.test.model.room;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.ai.ConcreteAIEnemy;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.RoomType;
import it.unibo.isaccoop.model.creator.ConcreteCreatorFactory;
import it.unibo.isaccoop.model.creator.CreatorFactory;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.player.Player;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.room.Room;
import it.unibo.isaccoop.model.room.RoomImpl;

/**
 * Room test. These tests are meant to check only if getters in {@link Room} work properly.
 * Checks on Room field depending of the {@link RoomType} are in {@link RoomBuilderTest}.
 */
class RoomTest {

    private static final int MAX_COORD_NUMBER = 20;
    private static final int MAX_ROOM_SIZE = 200;
    private final Map<RoomType, Room> rooms = new HashMap<>();
    private final Map<RoomType, Boolean> completed = Map.of(
            RoomType.START, true, RoomType.SHOP, true, RoomType.STANDARD, false, 
            RoomType.BOSS, false, RoomType.TREASURE, true);
    private final CreatorFactory creator = new ConcreteCreatorFactory();
    
    private final List<Enemy> enemies = creator.createEnemies().create();
    private final AIEnemy aienemy = new ConcreteAIEnemy(enemies);
    private final List<Item> items = creator.createItems().create();
    private final List<PowerUp> powerups = creator.createShopPowerUps().create();
    private final Player player = new Player();
    
    @BeforeEach
    void setUp() {
        for (final var type: RoomType.values()) {
            this.rooms.put(type, new RoomImpl(getRandomNumber(), getRandomNumber(), generateCoord(), type, 
                    Optional.of(aienemy), Optional.of(items), Optional.of(powerups), Optional.of(player), 
                    Optional.of(enemies)));
        }
    }

    @Test
    void testGetRoomType() {
        assertTrue(this.rooms.entrySet().stream()
                .allMatch(entry -> entry.getKey() == entry.getValue().getRoomType()));
    }

    @Test
    void testGetRoomAI() {
        assertTrue(this.rooms.values().stream()
                .allMatch(r -> r.getRoomAI().get() == this.aienemy));
    }

    @Test
    void testGetItems() {
        assertTrue(this.rooms.values().stream()
                .allMatch(r -> r.getItems().get() == this.items));
    }

    @Test
    void testGetPowerUps() {
        assertTrue(this.rooms.values().stream()
                .allMatch(r -> r.getPowerUps().get() == this.powerups));
    }

    @Test
    void testGetPlayer() {
        assertTrue(this.rooms.values().stream()
                .allMatch(r -> r.getPlayer().get() == this.player));
    }

    @Test
    void testGetEnemies() {
        assertTrue(this.rooms.values().stream()
                .allMatch(r -> r.getEnemies().get() == this.enemies));
    }

    @Test
    void testIsComplete() {
    }

    /**
     * Utility method to generate a new random {@link Point2D}.
     * @return a new Point2D
     */
    private Point2D generateCoord() {
        return new Point2D(ThreadLocalRandom.current().nextInt(MAX_COORD_NUMBER), 
                ThreadLocalRandom.current().nextInt(MAX_COORD_NUMBER));
    }

    private int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(MAX_ROOM_SIZE);
    }
}
