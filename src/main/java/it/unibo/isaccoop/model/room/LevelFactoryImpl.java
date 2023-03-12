package it.unibo.isaccoop.model.room;

/**
 * Implementation of {@link LevelFactory}.
 */
public class LevelFactoryImpl implements LevelFactory {

    private final int numberOfRooms;
    private final int gridRows;
    private final int gridCols;
    
    public LevelFactoryImpl(int numberOfRooms, int gridRows, int gridCols) {
        this.numberOfRooms = numberOfRooms;
        this.gridRows = gridRows;
        this.gridCols = gridCols;
    }

    @Override
    public Level createLevel(final int numberOfRooms, final int gridRows, final int gridCols) {
        return null;
    }

}
