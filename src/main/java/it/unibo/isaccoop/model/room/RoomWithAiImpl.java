package it.unibo.isaccoop.model.room;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.model.ai.AIEnemy;
import it.unibo.isaccoop.model.common.RoomType;

/**
 * Implementation of {@link Room}.
 */
public class RoomWithAiImpl extends AbstractRoom implements RoomWithAi {

    private final AIEnemy roomAI; //contains the list of enemies
    //lista powerup, obstacles, optional<Boss>

    /**
     * @param id id of this {@link Room}
     * @param width horizontal dimension of this {@link Room}
     * @param height vertical dimension of this {@link Room}
     * @param coord coordinate of this {@link Room}
     * @param doors list of all the doors in this {@link Room}
     * @param roomType type of this {@link Room}
     * @param roomAI {@link AIEnemy} impl to attach to this {@link Room}
     */
    public RoomWithAiImpl(final int id, final int width, final int height,
            final Pair<Integer, Integer> coord, final List<Door> doors, final RoomType roomType,
            final AIEnemy roomAI) {
        super(id, width, height, coord, roomType);
        this.roomAI = roomAI;
    }

    @Override
    public AIEnemy getRoomAI() {
        return this.roomAI;
    }
}
