package it.unibo.isaccoop.model.collision;

import java.util.List;
import it.unibo.isaccoop.model.boundingbox.CircleBoundingBox;
import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.player.Player;
/**
 *
 * Factory for check Collision.
 *
 */
public final class CollisionCheckFactoryImpl implements CollisionCheckFactory {

    @Override
    public CollisionCheck getCollisionWithItemChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> elem.getBox().isCollidingWithCricle(elem.getCoords(), p.getCoords(), 
                        (CircleBoundingBox) p.getBox()))
                .forEach(e -> room.notifyEvent(new ConcreteEventFactory().getItemPickUpEvent((Item) e)));
    }

    @Override
    public CollisionCheck getCollisionPlayerShotChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> p.getWeaponShots().stream()
                .anyMatch(shot -> shot.getBox()
                        .isCollidingWithCricle(shot.getCoords(), elem.getCoords(), (CircleBoundingBox) elem.getBox())))
                .forEach(e -> room.notifyEvent(new ConcreteEventFactory().getEnemyShot((Enemy) e)));
    }

    @Override
    public CollisionCheck getCollisionWithEnemyChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> elem.getBox().isCollidingWithCricle(elem.getCoords(), p.getCoords(), 
                        (CircleBoundingBox) p.getBox()))
                .forEach(e -> room.notifyEvent(new ConcreteEventFactory().getEnemyHitEvent()));
    }

    @Override
    public CollisionCheck getCollisionWithEnemyShotChecker(final Player p, final List<MapElement> i) {
        return room -> i.stream()
                .filter(elem -> p.getBox().isCollidingWithCricle(p.getCoords(), elem.getCoords(), 
                        (CircleBoundingBox) elem.getBox()))
                .forEach(e -> room.notifyEvent(new ConcreteEventFactory().getEnemyHitEvent()));
    }

}
