package it.unibo.isaccoop.model.enemy;

/***/
public class ShootingEnemy extends Enemy {

    private final EnemyWeapon weapon;

    /***/
    public ShootingEnemy() {
        this.weapon = new EnemyWeapon();
    }

    /**
     *  Get {@link EnemyWeapon} object for this {@link ShootingEnemy}.
     *
     *  @return {@link EnemyWeapon} for this {@link ShootingEnemy}
     * */
    public EnemyWeapon getWeapon() {
        return weapon;
    }

}
