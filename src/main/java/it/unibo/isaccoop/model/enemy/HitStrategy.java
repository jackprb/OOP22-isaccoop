package it.unibo.isaccoop.model.enemy;

import java.util.Optional;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public interface HitStrategy {

    /**
     * @param direction the direction in which i fire the shot
     * @param caller
     * */
    void hit(Optional<Vector2D> direction, MapElement caller);
}
