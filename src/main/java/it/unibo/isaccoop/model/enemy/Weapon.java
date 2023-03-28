package it.unibo.isaccoop.model.enemy;

import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Removable;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public interface Weapon extends Removable {

    /***/
    void shoot(Point2D enemyPosition, Vector2D direction);

    /***/
    List<WeaponShot> getWeaponShots();

}
