package it.unibo.isaccoop.model.spawn;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.unibo.isaccoop.model.boundingbox.CircleBoundingBox;
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
            e.setCoords(new Point2D(ThreadLocalRandom.current()
                    .nextDouble(((CircleBoundingBox) e.getBox()).getRadius() + 1 , width - ((CircleBoundingBox) e.getBox()).getRadius() - 1),
                    ThreadLocalRandom.current()
                    .nextDouble(((CircleBoundingBox) e.getBox()).getRadius() + 1 , height - ((CircleBoundingBox) e.getBox()).getRadius() - 1)));
        });

    }

}
