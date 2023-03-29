package it.unibo.isaccoop.core;

import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

import it.unibo.isaccoop.controller.input.InputController;
import it.unibo.isaccoop.controller.input.KeyboardInputController;

/**
 *
 *
 */
public class GameEngineImpl implements GameEngine {

    private Map<String, InputController> controllers = new HashMap<>();

    @Override
    public void initGame() {
        this.controllers.put("keyMove", new KeyboardInputController(VK_W, VK_S, VK_A, VK_D));
        this.controllers.put("keyShot", new KeyboardInputController(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT));
    }

    @Override
    public InputController getController(String name) {
        return this.controllers.get(name);
    }

}
