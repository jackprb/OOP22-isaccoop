package it.unibo.isaccoop.model;

import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.common.MapElementImpl;

/**
 * Implementation of {@link Door}.
 */
public final class DoorImpl extends MapElementImpl implements Door {

    private final Room room;

    /**
     * @param id id of this {@link Door}
     * @param width horizontal dimension of this {@link Door}
     * @param height vertical dimension of this {@link Door}
     * @param coord coordinates of this {@link Door}
     * @param room the room reachable via this {@link Door}
     */
    public DoorImpl(final int id, final int width, final int height, 
            final Pair<Integer, Integer> coord, final Room room) {
        super(id, width, height, coord);
        this.room = room;
    }

    @Override
    public Room getCorrespondingRoom() {
        return this.room;
    }
}
