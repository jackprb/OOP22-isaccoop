package it.unibo.isaccoop.model.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.powerup.CoinUp;
import it.unibo.isaccoop.model.powerup.DamageUp;
import it.unibo.isaccoop.model.powerup.HealthUp;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.powerup.RangeUp;
import it.unibo.isaccoop.model.powerup.SpeedUp;
import it.unibo.isaccoop.model.powerup.TearsUp;
/***/
public class ShopRoomCreator implements Creator<PowerUp> {
    private final List<PowerUp> itemsInShopRoom;
    private static final int ITEMS_IN_SHOP = 3;
    private static final Logger LOGGER = Logger.getLogger(ShopRoomCreator.class.getName());
    /***/
    public ShopRoomCreator() {
        this.itemsInShopRoom = new ArrayList<>();
    }

    /***/
    @Override
    public List<PowerUp> create() {
        Stream.iterate(0, x -> x + 1).
        limit(ShopRoomCreator.ITEMS_IN_SHOP).
        forEach(e -> this.itemsInShopRoom.add(this.generatePowerUp().get()));
        return List.copyOf(this.itemsInShopRoom);
    }

    /**
     * @return a random power up.
     * */
    private Optional<PowerUp> generatePowerUp() {
        final var powerUpsList = new ArrayList<>(List.of(CoinUp.class, DamageUp.class, HealthUp.class,
                RangeUp.class, SpeedUp.class, TearsUp.class));
        final var random = ThreadLocalRandom.current().nextInt(powerUpsList.size());
        try {
            final var powerUp = powerUpsList.get(random).getDeclaredConstructor().newInstance();
            powerUp.setSuperItem(ThreadLocalRandom.current().nextBoolean());
            return Optional.of(powerUp);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            LOGGER.severe(e.getMessage());
        }
        return Optional.empty();
    }

}
