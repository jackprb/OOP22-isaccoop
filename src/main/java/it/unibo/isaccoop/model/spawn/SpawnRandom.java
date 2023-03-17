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
     *
     */
    @Override
    public void setPosition(final List<MapElement> elementsToSpawn) {
        elementsToSpawn.forEach(e -> {
            e.setCoords(new Point2D(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble()));
        });

    }

}
