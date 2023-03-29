package it.unibo.isaccoop.model.weapon;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;

/***/
public abstract class AbstractWeapon implements Weapon {

    /**
     * Weapon shots list field.
     * */
    private final List<WeaponShot> weaponShots;

    /**
     *  Constructor for {@link EnemyWeapon}.
     * */
    public AbstractWeapon() {
       this.weaponShots = new ArrayList<>();
    }

    /**
     *  Add weapon shot to weapon shots list.
     *
     *  @param newShot new shot to attach to shots list
     * */
    protected void addWeaponShot(final WeaponShot newShot) {
        this.weaponShots.add(newShot);
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
