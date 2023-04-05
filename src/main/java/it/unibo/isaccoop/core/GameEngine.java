package it.unibo.isaccoop.core;
/**
 *
 *
 */

import java.util.Collection;

import it.unibo.isaccoop.controller.input.ActionController;
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
     * Method that returns the ActionController present in the game engine.
     * @return actionController indicated.
     */
    public ActionController getActionController();

    /**
     * @return InputController refers to String name
     */
    Collection<KeyboardInputController> getKeyboardInputControllers();
}
