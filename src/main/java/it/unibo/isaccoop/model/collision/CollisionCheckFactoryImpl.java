package it.unibo.isaccoop.model.collision;

import java.util.List;

import it.unibo.isaccoop.model.common.AbstractMapElement.ElementsRadius;
import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.player.Player;
/**
 *
 * Factory for check Collision.
 *
 */
public class CollisionCheckFactoryImpl implements CollisionCheckFactory {

    @Override
    public CollisionCheck getCollisionWithItemChecker(Player p, List<MapElement> i) {
        return () -> i.stream().filter(elem -> elem.getBox().isCollidingWith(p.getCoords(), elem.getCoords(), ElementsRadius.PLAYER.getValue()));
    }

    @Override
    public CollisionCheck getCollisionPlayerShotChecker(Player p, List<MapElement> e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CollisionCheck getCollisionWithEnemyChecker(Player p, List<MapElement> e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CollisionCheck getCollisionWithEnemyShotChecker(Player p, List<MapElement> e) {
        // TODO Auto-generated method stub
        return null;
    }

}
