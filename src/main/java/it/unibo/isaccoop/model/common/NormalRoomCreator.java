package it.unibo.isaccoop.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.item.Coin;
import it.unibo.isaccoop.model.item.Heart;
import it.unibo.isaccoop.model.item.Item;
/**
 * Represents the creator for normal rooms.
 * */
public class NormalRoomCreator implements Creator<Item> {
    private static final int MAX_ITEMS_IN_ROOM = 3;
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
            forEach(e -> itemsInNormalRoom.add(this.generateRandomItem()));

        return List.copyOf(itemsInNormalRoom);
    }

    /**
     * Generate random item.
     * @return random Item.
     * */
    private Item generateRandomItem() {
        return ThreadLocalRandom.current().nextBoolean() ? new Coin() : new Heart();
    }

}
