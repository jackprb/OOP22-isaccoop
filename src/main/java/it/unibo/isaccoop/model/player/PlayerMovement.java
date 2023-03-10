package it.unibo.isaccoop.model.player;

/**
 * Interface for the player movement.
 * */
public interface PlayerMovement {

    /**
     * @return if the player can move in one direction.
     * */
    boolean isMovementAvailable();

    /**
     * Move the player to the left.
     * */
    void left();

    /**
     * Move the player to the right.
     * */
    void right();

    /**
     * Move the player up.
     * */
    void up();

    /**
     * Move the player down.
     * */
    void down();
}
