package it.unibo.isaccoop.core;

import it.unibo.isaccoop.controller.input.InputComponent;
import it.unibo.isaccoop.model.room.Level;

/**
 *
 *
 */
public class GameLoopImpl implements GameLoop {

    private Level level;
    private InputComponent inputComponent;

    @Override
    public void gameLoop() {
        // TODO Auto-generated method stub

    }
    /**
     * Private method that updates the input.
     */
    private void processInput() {
        level.getRooms().stream().filter(r -> r.getPlayer().isPresent())
            .forEach(x -> inputComponent.update(x.getPlayer().get()));

    }
    /***/
    private void updateGame() {
        // TODO Auto-generated method stub

    }
    /***/
    private void render() {
        // TODO Auto-generated method stub

    }



}
