package it.unibo.isaccoop.model.spawn;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.tuple.Pair;
import it.unibo.isaccoop.model.common.MapElement;

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
            e.setCoords(Pair.of(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble()));
        });

    }

}
