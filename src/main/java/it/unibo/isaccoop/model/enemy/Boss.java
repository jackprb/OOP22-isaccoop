package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.Point2D;

/**
 * The class for the boss.
 * */
public class Boss extends AbstractEnemy {

    /**
     * Shooting boss.
     * */
    private final ShootingEnemy shotBoss;

    /**
     * Boss that doesn't shoot.
     * */
    private final NonShootingEnemy nonShotBoss;

    /**
     * The time to wait to change the boss's attack type.
     * */
    private static final int CHANGE_TIME = 10_000;

    /**
     * The time since the last change.
     * */
    private long lastChangeTime;

    /**
     * To figure out what kind of attack the boss has.
     * */
    private boolean isShotBoss;

    /**
     * Boss constructor.
     * */
    public Boss() {
        super(EnemyHearts.BOSS_HEARTS);
        this.shotBoss = new ShootingEnemy();
        this.nonShotBoss = new NonShootingEnemy();
        this.lastChangeTime = System.currentTimeMillis();
        this.isShotBoss = false;
    }

    /**
     * Change the type of attack of the boss based on time, with shooting or not.
     * @return if the Boss have to change the type of attack
     * */
    public boolean changeMode() {
        if (System.currentTimeMillis() - this.lastChangeTime >= Boss.CHANGE_TIME) {
            this.isShotBoss = !this.isShotBoss;
            this.lastChangeTime = System.currentTimeMillis();
        }
        return this.isShotBoss;
    }

    /**
     * Hit the player.
     * */
    @Override
    public void hit(final Point2D playerPosition) {
        if (this.changeMode()) {
            this.shotBoss.hit(playerPosition);
            this.nonShotBoss.setCoords(this.shotBoss.getCoords());
        } else {
            this.nonShotBoss.hit(playerPosition);
            this.shotBoss.setCoords(this.nonShotBoss.getCoords());
        }
    }

    /**
     * Move the boss towards the player.
     * */
    @Override
    public void move(final Point2D playerPosition) {
        if (this.changeMode()) {
            this.shotBoss.move(playerPosition);
            this.nonShotBoss.setCoords(this.shotBoss.getCoords());
        } else {
            this.nonShotBoss.move(playerPosition);
            this.shotBoss.setCoords(this.nonShotBoss.getCoords());
        }
    }
}
