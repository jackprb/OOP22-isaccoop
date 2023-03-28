package it.unibo.isaccoop.controller.input;
import it.unibo.isaccoop.model.player.Player;

public abstract class AbstractInputComponent implements InputComponent {

    private final Player player;
    
    /**
     * 
     * @param player
     */
    public AbstractInputComponent(Player player) {
        this.player = player;
    }

    /**
     * 
     */
    @Override
    public void update() {
    }

    /**
     * 
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

}
