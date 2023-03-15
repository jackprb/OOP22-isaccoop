package it.unibo.isaccoop.model.spawn;

/**
 * 
 * @param <E>
 */
public interface Spawn<E> {

    /**
     * Method that set the position of the element inside the room.
     * @param elementToSpawn
     */
    void setPosition(E elementToSpawn);
}
