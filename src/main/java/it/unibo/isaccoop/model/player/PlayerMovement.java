package it.unibo.isaccoop.model.player;

import javax.swing.JFrame;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Interface for the player movement.
 * */
public interface PlayerMovement {

    /**
     * @return if the player can move in one direction.
     * */
    boolean isMovementAvailable();

    /**
     * Move the player.
     * @param map
     * */
    void move(JFrame map);

    /**
     * Update the player position.
     * @param position current position of the player
     * */
    void setPlayerPosition(Pair<Double, Double> position);

}
