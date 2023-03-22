package it.unibo.isaccoop.model.spawn;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Point2D;

/**
 *
 *
 */
public class SpawnRandom implements Spawn {

    /**
     * Method that set a random position of the elements inside the room, in a random way.
     * @param elementsToSpawn
     * @param width of room
     * @param height of room
     */
    @Override
    public void setPosition(final List<MapElement> elementsToSpawn, final int width, final int height) {
        elementsToSpawn.forEach(e -> {
            e.setCoords(new Point2D(ThreadLocalRandom.current().nextDouble(Double.valueOf(width)),
                    ThreadLocalRandom.current().nextDouble(Double.valueOf(height))));
        });

    }

}
