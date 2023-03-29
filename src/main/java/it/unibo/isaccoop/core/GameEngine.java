package it.unibo.isaccoop.core;
/**
 *
 *
 */

import it.unibo.isaccoop.controller.input.InputController;

public interface GameEngine {
    /**
     *
     */
    void initGame();
    /**
     *
     * @param name
     * @return
     */
    InputController getController(String name);
}
