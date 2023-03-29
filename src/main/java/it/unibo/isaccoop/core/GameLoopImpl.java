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
    private long period = 20;

    @Override
    public void gameLoop() {
        while(!level.isComplete()) {
            long current = System.currentTimeMillis();
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
            .forEach(x -> inputComponent.update(x.getPlayer().get()));

    }
    /***/
    private void updateGame() {
        level.getRooms().stream().filter(r -> r.getPlayer().isPresent())
            .forEach(x -> {
                x.updateRoom();
                x.executeEvents();
            });

    }
    /***/
    private void render() {
        // TODO Auto-generated method stub

    }

    /**
     *
     */
    private void waitForNextFrame(long current){
        long dt = System.currentTimeMillis() - current;
        if (dt < period){
            try {
                Thread.sleep(period - dt);
            } catch (Exception ex){}
        }
    }


}
