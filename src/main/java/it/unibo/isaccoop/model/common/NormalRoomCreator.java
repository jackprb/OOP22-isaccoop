package it.unibo.isaccoop.model.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.item.Coin;
import it.unibo.isaccoop.model.item.Heart;
import it.unibo.isaccoop.model.item.Item;
/**
 * Represents the creator for normal rooms.
 * */
public class NormalRoomCreator implements Creator<Item> {
    private static final int MAX_ITEMS_IN_ROOM = 3;
    private static final Logger LOGGER = Logger.getLogger(NormalRoomCreator.class.getName());
    private final List<Item> itemsInNormalRoom;
    /**
     * Normal room constructors.
     * */
    public NormalRoomCreator() {
        this.itemsInNormalRoom = new ArrayList<>();
    }

    /**
     *  @return List of random items.
     * */
    @Override
    public List<Item> create() {
        Stream.iterate(0, x -> x + 1).
            limit(ThreadLocalRandom.current().nextInt(NormalRoomCreator.MAX_ITEMS_IN_ROOM)).
            forEach(e -> itemsInNormalRoom.add(this.generateRandomItem().get()));

        return List.copyOf(itemsInNormalRoom);
    }

    /**
     * Generate random item.
     * @return random Item.
     * */
    private Optional<Item> generateRandomItem() {
        final var itemList = new ArrayList<>(List.of(Coin.class, Heart.class));
        final var random = ThreadLocalRandom.current().nextInt(itemList.size());
        try {
            final var item = itemList.get(random).getDeclaredConstructor().newInstance();
            return Optional.of(item);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            LOGGER.severe(e.getMessage());
        }
        return Optional.empty();

    }

}
