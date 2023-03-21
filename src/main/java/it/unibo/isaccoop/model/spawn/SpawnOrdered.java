/**
 *
 */
package it.unibo.isaccoop.model.spawn;

import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Point2D;

/**
 *
 */
public class SpawnOrdered implements Spawn {

    /**
     *
     */
    @Override
    public void setPosition(final List<MapElement> elementsToSpawn) {
        elementsToSpawn.forEach(e -> {
          //fissiamo gli item al centro della room, heigh/2 e controlliamo la
          //size della lista e poi /2 se 1 elem e /4 se 3 elem
            e.setCoords(new Point2D(0, 0));
        });
    }

}
