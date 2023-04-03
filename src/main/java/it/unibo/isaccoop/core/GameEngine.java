package it.unibo.isaccoop.core;
/**
 *
 *
 */

import java.util.Collection;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.controller.input.KeyboardInputController;
/**
 * Interface representing the game engine.
 * */
public interface GameEngine {
    /**
     * Method that starts the game engine.
     */
    void run();

    /**
     * Method that returns the controllers present in the game engine.
     * @param name reference to specific controller.
     * @return controller indicated.
     */
    InputController getController(String name);
    /**
     * @return InputController refers to String name
     */
    Collection<KeyboardInputController> getKeyboardInputControllers();
}
