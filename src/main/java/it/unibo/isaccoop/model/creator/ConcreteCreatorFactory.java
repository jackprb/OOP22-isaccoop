package it.unibo.isaccoop.model.creator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.common.ShopRoomCreator;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.AbstractItem;
import it.unibo.isaccoop.model.item.Coin;
import it.unibo.isaccoop.model.item.Heart;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.CoinUp;
import it.unibo.isaccoop.model.powerup.DamageUp;
import it.unibo.isaccoop.model.powerup.HealthUp;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.powerup.RangeUp;
import it.unibo.isaccoop.model.powerup.SpeedUp;
import it.unibo.isaccoop.model.powerup.TearsUp;
/**
 *
 *
 */
public class ConcreteCreatorFactory implements CreatorFactory{
    private static final Logger LOGGER = Logger.getLogger(ConcreteCreatorFactory.class.getName());
    private static final int ITEMS_IN_SHOP = 3;
    private static final List<Class<? extends Item>> itemList = new ArrayList<>(List.of(Coin.class, Heart.class));
    private static final List<Class<? extends PowerUp>> powerUpsList = new ArrayList<>(List.of(CoinUp.class, DamageUp.class, HealthUp.class,
            RangeUp.class, SpeedUp.class, TearsUp.class));
    @Override
    public Creator<Enemy> createEnemies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Creator<Enemy> createBoss() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Creator<PowerUp> createShopPowerUps() {
        return () -> Stream.iterate(0, x -> x + 1)
                .limit(ConcreteCreatorFactory.ITEMS_IN_SHOP)
                .map(e -> this.generatePowerUp().get())
                .collect(Collectors.toList());
    }

    @Override
    public Creator<PowerUp> createTreasurePowerUps() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Creator<Item> createItems() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return a random power up.
     * */
    private Optional<PowerUp> generatePowerUp() {
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
