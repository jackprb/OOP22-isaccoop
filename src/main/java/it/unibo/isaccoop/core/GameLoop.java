package it.unibo.isaccoop.core;
/**
 * Interface representing the game loop.
 *
 */
public interface GameLoop {
    /**
     *
     */
    void processInput();
    /**
     *
     */
    void updateGame();
    /**
     *
     */
    void render();
}
