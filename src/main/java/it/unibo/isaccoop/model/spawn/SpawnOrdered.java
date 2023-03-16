/**
 * 
 */
package it.unibo.isaccoop.model.spawn;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.isaccoop.model.common.MapElement;

/**
 *
 */
public class SpawnOrdered implements Spawn {

    /**
     * 
     */
    @Override
    public void setPosition(List<MapElement> elementsToSpawn) {
        elementsToSpawn.forEach(e ->{
            e.setCoords(Pair.of(null, null));//fissiamo gli item al centro della room, heigh/2 e controlliamo la size della lista e poi /2 se 1 elem e /4 se 3 elem
        });
    }

}
