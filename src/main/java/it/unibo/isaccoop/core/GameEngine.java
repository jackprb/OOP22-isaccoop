package it.unibo.isaccoop.core;
/**
 *
 *
 */

import it.unibo.isaccoop.controller.input.InputController;
/**
 * Interface representing the game engine.
 * */
public interface GameEngine {
    /**
     * Method that initializes the initial game values.
     */
    void initGame();
    /**
     * Method that returns the controllers present in the game engine.
     * @param name reference to specific controller.
     * @return controller indicated.
     */
    InputController getController(String name);
}
