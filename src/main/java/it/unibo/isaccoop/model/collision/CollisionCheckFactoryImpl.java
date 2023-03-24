package it.unibo.isaccoop.model.collision;

import java.util.List;

import it.unibo.isaccoop.model.common.AbstractMapElement.ElementsRadius;
import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.player.Player;
/**
 *
 * Factory for check Collision.
 *
 */
public class CollisionCheckFactoryImpl implements CollisionCheckFactory {
    /**
     *
     */
    @Override
    public CollisionCheck getCollisionWithItemChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> elem.getBox().isCollidingWith(p.getCoords(), elem.getCoords(), ElementsRadius.PLAYER.getValue()))
                .forEach(e -> room.notifyEvent(new ConcreteEventFactory().getItemPickUpEvent((Item) e)));
    }
    /**
     *
     */
    @Override
    public CollisionCheck getCollisionPlayerShotChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> elem.getBox().isCollidingWith(p.getCoords(), elem.getCoords(), ElementsRadius.PLAYER.getValue()));
    }
    /**
     *
     */
    @Override
    public CollisionCheck getCollisionWithEnemyChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> elem.getBox().isCollidingWith(p.getCoords(), elem.getCoords(), ElementsRadius.PLAYER.getValue()));
    }
    /**
     *
     */
    @Override
    public CollisionCheck getCollisionWithEnemyShotChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> elem.getBox().isCollidingWith(p.getCoords(), elem.getCoords(), ElementsRadius.PLAYER.getValue()));
    }

}
