package it.unibo.isaccoop.model.room;

/**
 * Delegated class to check conditions while creating rooms.
 */
public final class RoomFactoryLogics {

    private final int totalNumberOfRooms;
    
    public RoomFactoryLogics(final int totalNumberOfRooms) {
        this.totalNumberOfRooms = totalNumberOfRooms;
    }

    /**
     * Check if the next room to generate can be a START room.
     * @param roomCount the number of rooms currently generated (0-based count)
     * @return true if can build START room (i.e.: if this is the FIRST room - with roomCount = 0), 
     * false otherwise
     */
    public boolean canBuildStartRoom(final int roomCount) {
        return roomCount == 0;
    }

    /**
     * Check if the next room to generate can be a BOSS room.
     * @param roomCount the number of rooms currently generated (0-based count)
     * @return true if can build BOSS room (i.e.: if this is the LAST room - 
     * with roomCount = totalNumberOfRooms - 1), false otherwise
     */
    public boolean canBuildBossRoom(final int roomCount) {
        return roomCount == this.totalNumberOfRooms - 1;
    }
    
    /**
     * Check if the next room to generate can be a NON BOSS or NON START room.
     * @param roomCount the number of rooms currently generated (0-based count)
     * @return true if can build a NON BOSS or NON START room (i.e.: if this is not the FIRST or LAST room),
     * false otherwise
     */
    public boolean canBuildNonBossNonStartRoom(final int roomCount) {
        return roomCount == this.totalNumberOfRooms;
    }
}
