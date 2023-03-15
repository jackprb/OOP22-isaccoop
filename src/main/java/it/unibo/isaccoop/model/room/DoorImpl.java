package it.unibo.isaccoop.model.room;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.MapElementImpl;

/**
 * Implementation of {@link Door}.
 */
public final class DoorImpl extends MapElementImpl implements Door {

    private final Room room;

    /**
     * @param width horizontal dimension of this {@link Door}
     * @param height vertical dimension of this {@link Door}
     * @param coord coordinates of this {@link Door}
     * @param room the room reachable via this {@link Door}
     */
    public DoorImpl(final int width, final int height,
            final Pair<Double, Double> coord, final Room room) {
        super(width, height, coord);
        this.room = room;
    }

    @Override
    public Room getCorrespondingRoom() {
        return this.room;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((room == null) ? 0 : room.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DoorImpl other = (DoorImpl) obj;
        if (room == null) {
            if (other.room != null) {
                return false;
            }
        } else if (!room.equals(other.room)) {
            return false;
        }
        return true;
    }
}
