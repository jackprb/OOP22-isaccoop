package it.unibo.isaccoop.model.room;

import it.unibo.isaccoop.model.ai.AIEnemy;

public interface RoomWithAi extends Room{

    /**
     * Get {@link AIEnemy} attached to this {@link Room}.
     *
     * @return {@link AIEnemy} attached to this {@link Room}
     * */
    AIEnemy getRoomAI();
}
