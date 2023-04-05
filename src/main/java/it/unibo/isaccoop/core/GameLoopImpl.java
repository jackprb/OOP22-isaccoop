package it.unibo.isaccoop.core;

import java.util.List;
import java.util.logging.Logger;

import it.unibo.isaccoop.controller.input.ActionComponent;
import it.unibo.isaccoop.controller.input.ActionComponentImpl;
import it.unibo.isaccoop.controller.input.ActionControllerImpl;
import it.unibo.isaccoop.controller.input.InputComponent;
import it.unibo.isaccoop.controller.input.PlayerInputComponent;
import it.unibo.isaccoop.controller.input.ShotInputComponent;
import it.unibo.isaccoop.graphics.Scene;
import it.unibo.isaccoop.model.room.Level;

/**
 * Implementation of GameLoop.
 */
public class GameLoopImpl implements GameLoop {

    private Scene view;
    private Level level;
    private List<InputComponent> inputComponents;
    private ActionComponent actionComponent;
    private ActionControllerImpl actionController;
    private static final long DEFAULT_PERIOD = 20;
    private static final Logger LOGGER = Logger.getLogger(GameLoopImpl.class.getName());

    /**
     * GameLoopImpl constructor.
     *
     * @param view to be handle into game loop
     * @param level to be handle into game loop
     */
    public GameLoopImpl(final Scene view, final Level level, final ActionControllerImpl actionController) {
        this.view = view;
        this.level = level;
        this.inputComponents = List.of(new PlayerInputComponent(this.level.getCurrentRoom()),
                new ShotInputComponent());
        this.actionComponent = new ActionComponentImpl(this.level);
        this.actionController = actionController;
    }

    /**
     * Method that represents the main loop of the game.
     */
    @Override
    public void gameLoop() {
        while (!level.isLevelComplete()) {
            final long current = System.currentTimeMillis();
            this.processInput();
            this.updateGame();
            this.render();
            this.waitForNextFrame(current);
        }

    }

    /**
     * Private method that updates the input.
     */
    private void processInput() {
        level.getRooms().stream().filter(r -> r.getPlayer().isPresent())
            .forEach(x -> this.inputComponents.forEach(c -> c.update(x.getPlayer().get())));
        this.actionComponent.update(this.actionController);
    }
    /**
     * For each room present, update the room and check the events.
     * */
    private void updateGame() {
        level.getRooms().stream().filter(r -> r.getPlayer().isPresent())
            .forEach(x -> {
                x.updateRoom();
                x.executeEvents();
            });

    }
    /***/
    private void render() {
        view.render();
    }

    /**
     * Method to make the thread wait for the new frame.
     *
     * @param current represent current time.
     */
    private void waitForNextFrame(final long current) {
        final var period = GameLoopImpl.DEFAULT_PERIOD;
        final long dt = System.currentTimeMillis() - current;
        if (dt < period) {
            try {
                Thread.sleep(period - dt);
            } catch (InterruptedException e) {
                LOGGER.severe(e.getMessage());
            }
        }
    }


}
