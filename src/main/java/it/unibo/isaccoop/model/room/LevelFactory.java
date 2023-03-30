package it.unibo.isaccoop.model.room;

import it.unibo.isaccoop.model.player.Player;

/**
 * Interface that allows to create a {@link Level} dynamically.
 */
public interface LevelFactory {

    /**
     * Generates dynamically a Level made of numberOfRooms {@link Room}s, <br>
     * that will be placed in a grid with size (gridRows, gridCols). 
     * <br> So, it is required that <br> numberOfRooms <= (gridRows * gridCols).
     * It is also required that numberOfRooms >= 5.
     * 
     * @param numberOfRooms the number of rooms this level will have
     * @throws IllegalArgumentException if numberOfRooms IS NOT <= (gridRows * gridCols) is not
     * @return the level created
     */
    Level createLevel(int numberOfRooms);

    /**
     * Get the player.
     * @return the player
     */
    Player getPlayer();
}
