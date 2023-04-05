package it.unibo.isaccoop.model.room;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link Minimap}.
 */
public final class MinimapImpl implements Minimap {

    private Optional<Level> lvl = Optional.empty();

    public MinimapImpl(final Level currentLevel) {
        this.lvl = Optional.of(currentLevel);
    }

    @Override
    public Room getCurrentRoom() {
        if (this.lvl.isPresent()) {
            return this.lvl.get().getCurrentRoom();
        }
        throw new IllegalArgumentException("No level set");
    }

    @Override
    public List<Room> getCompletedRooms() {
        if (this.lvl.isPresent()) {
            return this.lvl.get().getRooms().stream()
                    .filter(r -> r.isComplete())
                    .collect(Collectors.toUnmodifiableList());
        }
        throw new IllegalArgumentException("No level set");
    }

    @Override
    public List<Room> getUncompletedRooms() {
        if (this.lvl.isPresent()) {
            return this.lvl.get().getRooms().stream()
                    .filter(r -> !r.isComplete())
                    .collect(Collectors.toUnmodifiableList());
        }
        throw new IllegalArgumentException("No level set");
    }
}
