package it.unibo.isaccoop.model.weapon;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.enemy.Weapon;
import it.unibo.isaccoop.model.enemy.WeaponShot;

public abstract class AbstractWeapon implements Weapon {

    protected final List<WeaponShot> weaponShots;

    /**
     *  Constructor for {@link EnemyWeapon}.
     * */
    public AbstractWeapon() {
       this.weaponShots = new ArrayList<>();
    }

    /**
     * Get the {@link EnemyWeaponShot} list for this {@link EnemyWeapon}.
     *
     * @return {@link EnemyWeaponShot} list for this {@link EnemyWeapon} as {@link List}
     * */
    @Override
    public List<WeaponShot> getWeaponShots() {
        return List.copyOf(this.weaponShots);
    }

    /**
     * Remove the bullet 'e' from the list.
     * @param e
     */
    @Override
    public void remove(final MapElement e) {
        this.weaponShots.remove(e);
    }

}
