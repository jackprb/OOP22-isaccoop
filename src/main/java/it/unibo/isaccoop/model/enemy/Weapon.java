package it.unibo.isaccoop.model.enemy;

import java.util.List;

import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.common.Removable;
import it.unibo.isaccoop.model.common.Vector2D;

/***/
public interface Weapon extends Removable {

    /**
     * @param startPosition the origin position
     * @param direction the direction where fire the shot
     * */
    void shoot(Point2D startPosition, Vector2D direction);

    /**
     * @return weapon shots list
     * */
    List<WeaponShot> getWeaponShots();

}
