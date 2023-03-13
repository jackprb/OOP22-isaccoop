package it.unibo.isaccoop.model.item;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.common.Creator;
/***/
public class NormalRoomCreator implements Creator<Item> {
    private static final int MAX_ITEMS_IN_ROOM = 3;
    private final List<Item> itemsInNormalRoom;
    /***/
    public NormalRoomCreator() {
        this.itemsInNormalRoom = new ArrayList<>();
    }

    /***/
    @Override
    public List<Item> create() {
        Stream.iterate(0, x -> x + 1).
            limit(ThreadLocalRandom.current().nextInt(NormalRoomCreator.MAX_ITEMS_IN_ROOM)).
            forEach(e -> itemsInNormalRoom.add(this.generateRandomItem()));

        return List.copyOf(itemsInNormalRoom);
    }

    /**
     * @return random Item.
     * */
    private Item generateRandomItem() {
        return ThreadLocalRandom.current().nextBoolean() ? new Coin() : new Heart();
    }

}
