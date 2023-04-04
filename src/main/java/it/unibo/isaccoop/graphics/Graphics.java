package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;

/***/
public interface Graphics {
    /**
     * Method to Draw room.
     */
    void drawRoom(MapElement room);
    /**
     * Method to Draw item.
     */
    void drawItem();
    /**
     * Method to Draw player.
     */
    void drawPlayer(MapElement player);
    /**
     * Method to Draw enemy.
     */
    void drawEnemy();

}
