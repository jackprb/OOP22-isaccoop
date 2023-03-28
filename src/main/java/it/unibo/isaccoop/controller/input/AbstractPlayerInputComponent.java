package it.unibo.isaccoop.controller.input;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.player.Player;

public abstract class AbstractPlayerInputComponent implements InputComponent {

    private final Player player;
    
    /**
     * 
     * @param player
     */
    public AbstractPlayerInputComponent(Player player) {
        this.player = player;
    }

    /**
     * @param e
     */
    @Override
    public void update(MapElement e) {
    }

}
