package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.model.common.RoomType;

public class RoomNoAiImpl extends AbstractRoom {

    public RoomNoAiImpl(final int id, final int width, final int height, 
            final Pair<Integer, Integer> coord, final RoomType roomType) {
        super(id, width, height, coord, roomType);
    }
}
