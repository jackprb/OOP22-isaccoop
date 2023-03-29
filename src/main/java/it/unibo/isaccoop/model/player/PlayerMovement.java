package it.unibo.isaccoop.model.player;

import it.unibo.isaccoop.model.common.Direction;

/**
 * Interface for the player movement.
 * */
public interface PlayerMovement {

    /**
     * Update the player position.
     * @param direction the direction in which the player moves
     * */
    void update(Direction direction);
}
