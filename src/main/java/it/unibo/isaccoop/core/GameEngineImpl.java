package it.unibo.isaccoop.core;

import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.VK_UP;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_W;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_D;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.controller.input.KeyboardInputController;
import it.unibo.isaccoop.graphics.Scene;
import it.unibo.isaccoop.graphics.SwingScene;

/**
 * Implementation of gameEngine.
 */
public class GameEngineImpl implements GameEngine {

    private Scene view;
    private final Map<String, InputController> controllers = new HashMap<>();
    /**
     * Method that initializes the initial game values.
     */
    @Override
    public void initGame() {
        this.controllers.put("keyMove", new KeyboardInputController(VK_W, VK_S, VK_A, VK_D));
        this.controllers.put("keyShot", new KeyboardInputController(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT));
        this.view = new SwingScene();
    }
    /**
     * Method that returns the controllers present in the game engine.
     * @param name reference to specific controller.
     * @return controller indicated.
     */
    @Override
    public InputController getController(final String name) {
        return this.controllers.get(name);
    }

}
