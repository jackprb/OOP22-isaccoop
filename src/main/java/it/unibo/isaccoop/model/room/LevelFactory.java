package it.unibo.isaccoop.model.room;

/**
 * Interface that allows to create a {@link Level} dynamically.
 */
public interface LevelFactory {

    /**
     * Generates dynamically a Level made of numberOfRooms {@link Room}s, <br>
     * that will be placed in a grid with size (gridRows, gridCols). 
     * <br> So, it is required that <br> numberOfRooms <= (gridRows * gridCols).
     * 
     * @param numberOfRooms the number of rooms this level will have
     * @param gridRows the number of rows of the grid
     * @param gridCols the number of columns of the grid
     * @throws IllegalArgumentException if numberOfRooms IS NOT <= (gridRows * gridCols) is not
     * @return the level created
     */
    Level createLevel(int numberOfRooms, int gridRows, int gridCols);
}
