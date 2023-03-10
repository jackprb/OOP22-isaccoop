package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.model.common.RoomType;

public class RoomNoAiImpl extends AbstractRoom {

    public RoomNoAiImpl(int id, int width, int height, 
            Pair<Integer, Integer> coord, RoomType roomType) {
        super(id, width, height, coord, roomType);
    }
}
